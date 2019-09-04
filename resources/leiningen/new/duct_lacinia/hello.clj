(ns {{name}}.resolver.hello
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :{{name}}.resolver.hello/get-world [_ _]
  (fn [context arguments value]
    (let [{:keys [name]} arguments]
      {:msg (str "Hello " name)})))
