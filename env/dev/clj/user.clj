(ns user
  (:require [luminus-migrations.core :as migrations]
            [app.config :refer [env]]
            [mount.core :as mount]
            app.core))

(defn start []
  (mount/start-without #'app.core/repl-server))

(defn stop []
  (mount/stop-except #'app.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))


