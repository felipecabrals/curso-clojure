(ns app.routes.home
  (:require [app.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [app.db.core :as db]))

(defn save-pessoa [{:keys [params]}]
  (db/set-pessoa! params)
    (response/found "/"))

(defn pessoa-get [pes_codigo]
  (layout/render
    "pessoa.html" {:pessoa (db/get-pessoa {:pes_codigo pes_codigo})}))

(defn update-pessoa [{:keys [params]}]
  (db/put-pessoa! params)
    (response/found "/"))
      
(defn delete-pessoa [pes_codigo]
  (db/del-pessoa! {:pes_codigo pes_codigo})
    (response/found "/"))
        
(defn home-page []
  (layout/render
    "home.html" {:pessoas (db/list-pessoa)}))
    
(defn pessoa-page []
  (layout/render "pessoa.html"))
    
(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/pessoa" [] (pessoa-page))
  (GET "/pessoa/:pes_codigo" [pes_codigo] (pessoa-get pes_codigo))
  (GET "/pessoa_del/:pes_codigo" [pes_codigo] (delete-pessoa pes_codigo))
  (POST "/pessoa_set" request (save-pessoa request))
  (GET "/api/pessoas" [] {:headers {"Content-Type" "application/json"} :body {:pessoas (db/list-pessoa)}})
  (POST "/pessoa_put" request (update-pessoa request)))