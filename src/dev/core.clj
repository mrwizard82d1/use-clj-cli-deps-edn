(ns dev.core)

;; Invoke the main function using clj by the command
;; `clj -M -m core.deps`. The `-M` option invokes the function,
;; `clojure.main`. The `-m core.deps` specifies the function that
;; `clojure.main` is to invoke (`core.deps`).
(defn -main []
  (println "Main function called"))


;; This function can be invoked using the `-X` option like
;; `clj -X dev.core/print-args :key1 "value1" :key2 "value2"`. Specifying
;; the arguments like this, using key-value pairs, generates a map
;; containing these key value pairs.
;;
;; An alternative is to specify the map as a single string argument
;; containing a Clojure string representation of a map; that is,
;; `clj -X dev.core/printargs "{:key1 value1, :key2 value2}"`.
;;
;; The result of both these command line formats is the same.
(defn print-args [args]
  "IMPORTANT: the argument, `args`, must be a **map**."
  (println "Passed arguments: " args))
