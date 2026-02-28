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
will focusing on running scripts and running Clojure namespaces.


- Concatenated aliaso to modify the clas



