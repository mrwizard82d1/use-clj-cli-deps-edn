(ns core-test
  (:require [clojure.test :as t]))

;; We will add a very simple `-main` function to our `core-test`
;; namespace and try to run this function.
;;
;; When I try to execute this function using `clj`, `clj` reports
;; an error: "Execution error (FileNotFoundException)....Could
;; not locate... on the classpath...."

(defn -main []
  (println "Testing in progress."))

;; Let's add a very simple test
(t/deftest always-true
  (t/is false))
