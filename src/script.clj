(ns script)

;; Run this script by:
;;
;; - Navigating to the project root
;; - Executing the command `clj -M src/script.clj`
;; - Optionally supply command line arguments
;;
;;   If you supply command line arguments, they will be collected
;;   into a list and passed to the script in the variable,
;;   `*command-line-args*`.

(println "This script called with args: " *command-line-args*)
