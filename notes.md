# Use Clojure CLI and deps.edn

This document contains notes from the YouTube video, "Use Clojure CLI 
and deps.edn to Build and Run Clojure app.tools.deps explained" by 
Vlodymyr Kozieiev. The video can be found at this link 
https://www.youtube.com/watch?v=8aCO_wNuScQ

## Introduction to the command line tools

The programs, `clj` and `clojure`, are almost the same command. The
difference is that `clj` executes its commands inside of `rlwrap`
which provides much better support for keyboard navigation in a
command line shell.

This command generates the contents of the `clj` script.
`which clj`
`cat $(which clj)`

Running `clojure` opens a REPL but with only limited support for 
keyboard navigation. (It does not even seem to support emacs 
navigation commands when run from a VTERM session inside emacs.)
`clojure`

Entering the partial clojure expression, `(+ 1 2` in the resulting
REPL provides limited navigation support inside a VTERM session in
emacs and even less support in a terminal


 We will primarily 
use `clj`.

## Using `clj`

The command, `clj --help`, prints all the details of the `clj` 
command. In the video, we will focus on three options:

- `-X[aliases]`
- `-T[toolname|aliases]`
- `-M[aliases]`

The `-M` option allows one to "[u]se concatenated aliases to modify 
classpath or supply main opts". It provides access to the clojure 
`main` namespace (see the Clojure web site, 
`https://clojure.org/reference/repl_and_main`, for detailed 
documentation.)

The Clojure main namespace takes a number of options itself, but we
will focusing on running scripts and running Clojure namespaces. For
example, if we create a file, `src/dev/core.clj` with Clojure code
defining the `-main` function, we can actually run that code from 
the command line using `clj -M -m dev.core`. The `-m` option 
"[c]all[s] the -main function from namespace" with arguments.

## Using the -T (tool) option

One tool is known to `clj` when installed, `tools`. You invoke it 
by executing the command, `clj -Ttools`. (NOTE: when you run this
command for the very first time on a system, Clojure will actually
**download** this tool to your workstation.)

Using `tools` allows access to other sub-commands:

- `list` List tools already installed on your workstation
- `install` Install a new tool to your workstation

I installed two development tools, `clj-new` and `dep-new`:

- `clojure -Ttools install-latest :lib com.github.seancorfield/clj-new :as clj-new`
- `clojure -Ttools install-latest :lib io.github.seancorfield/deps-new :as new`

Vlodimir installed a different package, `tools.deps.graphs`. This package helps 
one to visualize package dependencies. Here is the command line:

`clj -Ttools install io.github.clojure/tools.deps.graph '{:git/tag "v1.1.90"}' :as graph`

## Using the `deps.edn` file

### Basic usage

We create an empty `deps.edn` file and execute `clj -M -m dep.core`. 
Interestingly, when I execute this command locally, it works just as 
before. However, when Vlodomir executes this command in the video, it
fails with an error: "Error building classpath. Expected edn map in...."

Adding an empty configuration (`{)`) to `deps.edn` repairs the error in 
the video.

Suppose we add a `test` directory and create a file, `core-test.clj`. 
If we add a `-main` function to this file and try to run it with the 
command, `clj -M -m core-test`, we see an error:

> Execution error (FileNotFoundException) at....
> Could not locate ... on classpath... Please check....

We correct this error by configuring the `:paths` value in our 
configuration; that is:

`{:paths ["src" "test"]}`

Now, when we executing `clj -M -m core-test`, the program successfully 
prints the message, "Testing in progress."

Remember, by default, actually because of higher level `deps.edn` 
configuration, the path "src" is added to the Java classpath used by 
Clojure to search for source files. By specifying both "src" and 
"test", we allow Clojure to "find" the `-main` function in 
the package `core.test`.

### Adding dependencies

Let's add a new library for logging. The video uses the `timbre` 
library; however, `timbre` has been superseded by `telemere`. 
(These packages have the same main author.) Although `telemere`
uses a different (more modern?) approach to logging, it provides
macros that mimic the `timbre` API. This provision allows 
`telemere` to be backword compatible with `timbre`.

We can then execute our `-main` function. This execution produces 
the log message

```
2026-03-01T00:30:02.299290Z INFO LOG rocky dev.core :taoensso.telemere/timbre Main function called
```

Similarly, executing our `print-args` funcion produces:

```
2026-03-01T00:30:52.836162Z INFO LOG rocky dev.core :taoensso.telemere/timbre Passed arguments:  {:k1 "v1"}
```

#### Referencing Dependencies on GitHub

The `deps` key in the `deps.edn` file allows us to not only reference 
files available from Maven (and, I assume, Clojars), but to also 
reference packages (only) available on GitHub. When identifying a
package on GitHub, one must specify both a **tag** and a SHA to 
unambigously identify the version.

This particular package contains code that is **not** referenced in
source code but can be used from the command line. For example, this
command uses the Cognitect test runner to **find** and execute our 
"simple" tests.

We invoke this test runner with the command, 
`clj -M -m cognitect.test-runner`. This test runner will find and
execute our tests. However, we currently have no tests in our 
single test file, `test/core-test.clj`. Consequently, we see the 
general test output; however, it specifically reports 
"Ran 0 tests containing 0 assertions."

