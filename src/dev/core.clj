(ns dev.core)

;; The `-main` function can be run using `clj` by executing:
;;
;; - `clj -M -m dev.core`
;;
;; I'm unclear from the video explanation if one might supply
;; command line arguments. Currently, `-main` expects **no**
;; arguments. I think it would need to be changed to use
;; command line arguments.

(defn -main []
  (println "Main function called"))
