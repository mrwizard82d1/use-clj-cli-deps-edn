(ns reports)

(defn generate [{:keys [type tables]}]
  (println (format "Report of type %s generated for tables %s" type tables)))
