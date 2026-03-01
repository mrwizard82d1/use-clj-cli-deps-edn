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

## Usings the `deps.edn` file

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



