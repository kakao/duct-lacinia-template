(ns leiningen.new.duct-lacinia
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "duct-lacinia"))

(defn duct-lacinia [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' duct-lacinia project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["src/duct_hierarchy.edn" (render "duct_hierarchy.edn" data)]
             ["src/{{sanitized}}/main.clj" (render "main.clj" data)]
             ["src/{{sanitized}}/resolver/hello.clj" (render "hello.clj" data)]
             ["resources/{{sanitized}}/config.edn" (render "config.edn" data)]
             ["dev/src/dev.clj" (render "dev.clj" data)]
             ["dev/src/user.clj" (render "user.clj" data)]
             ["dev/resources/dev.edn" (render "dev.edn" data)])))
