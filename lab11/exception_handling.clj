
(ns exception-handling)

(println "===== Exception Handling in Clojure =====")

;; 1. Handling ArithmeticException
(println "\n1. ArithmeticException")

(try
  (let [result (/ 10 0)]
    (println "Result:" result))

  (catch ArithmeticException e
    (println "Caught ArithmeticException:"
             (.getMessage e)))

  (finally
    (println "Arithmetic operation completed.")))


;; 2. Handling NullPointerException
(println "\n2. NullPointerException")

(try
  (let [value nil]
    (.toUpperCase value))

  (catch NullPointerException e
    (println "Caught NullPointerException:"
             (.getMessage e)))

  (finally
    (println "Null check completed.")))


;; 3. Custom Exception using ex-info
(println "\n3. Custom Exception")

(defn check-age [age]
  (if (< age 18)
    (throw
     (ex-info "Age must be 18 or above."
              {:error :underage
               :provided-age age
               :minimum-age 18}))
    (str "Age " age " is valid.")))

(try
  (println (check-age 15))

  (catch clojure.lang.ExceptionInfo e
    (println "Caught Custom Exception:")
    (println "Error Message:" (ex-message e))
    (println "Error Data:" (ex-data e))

    ;; Graceful recovery
    (let [data (ex-data e)]
      (println "Recovery: Minimum required age is"
               (:minimum-age data))))

  (finally
    (println "Age validation completed.")))


;; 4. Successful execution without exception
(println "\n4. Normal Execution")

(try
  (println "Program executed successfully.")
  (catch Exception e
    (println "Unexpected error:" (ex-message e)))
  (finally
    (println "Program execution finished.")))

(println "\n===== Program Completed Successfully =====")
