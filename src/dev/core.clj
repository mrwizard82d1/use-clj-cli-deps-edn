(ns dev.core
  (:require [taoensso.telemere.timbre :as log]))

;; The `-main` function can be run using `clj` by executing:
;;
;; - `clj -M -m dev.core`
;;
;; I'm unclear from the video explanation if one might supply
;; command line arguments. Currently, `-main` expects **no**
;; arguments. I think it would need to be changed to use
;; command line arguments.

(defn -main []
  (log/info "DEV main function called"))

;; To run this function from the command line, one can use `clj`.
;;
;; The fully command line is `clj -X dev.core/print-args`.
;;
;; To pass a command line argument, one must supply a **single**
;; argument to the program (quoted in the shell). To pass multiple
;; arguments, supply them as a **Clojure map**.
;;
;; To supply this map of arguments, you have one of two options.
;; First, you can supply a sequence of quoted key-value pairs.
;; For example, `clj -X core.deps/print-args :k1 "v1" :k2 "v2"`.
;;
;; As an alternative, you can supply arguments as a literal Clojure
;; map like so: `clj -X core.deps/print-args "{:k1 "v1" :k2 "v2"}"`
;; If the nested quotation marks is confusing, one can use single
;; quotations to surround the entire map like:
;;
;; `clj -X core.deps/print-args '{:k1 "v1" :k2 "v2"}`

(defn print-args
  "Print its arguments: a very simple function."
  [args]
  (log/info "Passed arguments: " args))
