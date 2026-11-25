(ns lab12.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:import [java.sql DriverManager]))

(def data [45 80 90 35 70])

;; Sequence processing
(def passed (filter #(>= % 50) (map inc data)))
(def total (reduce + passed))

;; Database
(defn db []
  (DriverManager/getConnection "jdbc:sqlite:lab12.db"))

(defn save-data []
  (try
    (with-open [c (db)
                s (.createStatement c)]
      (.execute s "CREATE TABLE IF NOT EXISTS marks (score INTEGER)")
      (.execute s "DELETE FROM marks")
      (doseq [x passed]
        (.executeUpdate s (str "INSERT INTO marks VALUES (" x ")")))
      (println "Database saved successfully"))
    (catch Exception e
      (println "Database error:" (.getMessage e)))))

;; Ring endpoint
(defn app [req]
  (case (:uri req)
    "/" {:status 200 :body "Clojure Data Pipeline Running!"}
    "/results" {:status 200 :body (str passed)}
    "/total" {:status 200 :body (str total)}
    {:status 404 :body "Not Found"}))

;; Main
(defn -main [& args]
  (println "Original Data:" data)
  (println "Passed Marks:" passed)
  (println "Total:" total)
  (save-data)
  (println "Server running at localhost:3000")
  (run-jetty app {:port 3000 :join? true}))
