(ns script)

;; We can invoke this function from the command line by executing:
;; `clj -M src/script.clj`. Notice that we still specify `-M` to invoke
;; `clojure.main` but instead of calling a second "main" function, we
;; specify the (relative) pathname to our script.
(println "This script called with command-line args: " *command-line-args*)
