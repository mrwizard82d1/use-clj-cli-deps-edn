(ns dev.core)

;; Invoke the main function using clj by the command
;; `clj -M -m core.deps`. The `-M` option invokes the function,
;; `clojure.main`. The `-m core.deps` specifies the function that
;; `clojure.main` is to invoke (`core.deps`).
(defn -main []
  (println "Main function called"))
