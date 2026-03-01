(ns prod.core
  (:require [taoensso.telemere.timbre :as log]))

(defn -main []
  (log/info "PROD main function called"))

(defn print-args
  "Simply print its arguments."
  [args]
  (log/info "Passed arguments: " args))
