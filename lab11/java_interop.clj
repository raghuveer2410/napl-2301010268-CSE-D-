
(ns java-interop
  (:import [java.util ArrayList HashMap]))

(println "===== Java Interoperability in Clojure =====")

;; 1. Calling Java Static Methods
(println "\n1. Java Static Methods")

(println "Absolute value:" (Math/abs -25))
(println "Square root:" (Math/sqrt 144))
(println "Current time in milliseconds:"
         (System/currentTimeMillis))

;; 2. Creating Java Object Instances
(println "\n2. Creating Java Objects")

(def java-list (ArrayList.))
(def java-map (HashMap.))

;; 3. Invoking Instance Methods
(println "\n3. Java Instance Methods")

(.add java-list "Apple")
(.add java-list "Banana")
(.add java-list "Mango")

(println "ArrayList:" java-list)
(println "List size:" (.size java-list))
(println "First element:" (.get java-list 0))

(.put java-map "Name" "Raghuveer")
(.put java-map "Course" "Clojure")
(.put java-map "Year" 2026)

(println "HashMap:" java-map)
(println "Map size:" (.size java-map))
(println "Student name:" (.get java-map "Name"))

;; 4. Converting Clojure Collections to Java Collections
(println "\n4. Collection Conversion")

(def clojure-list [10 20 30 40 50])

(def converted-java-list
  (java.util.ArrayList. clojure-list))

(println "Clojure vector:" clojure-list)
(println "Converted Java ArrayList:" converted-java-list)

;; Converting Java Collection to Clojure Collection
(def converted-clojure-list
  (vec java-list))

(println "Java ArrayList:" java-list)
(println "Converted Clojure vector:" converted-clojure-list)

;; Converting Clojure Map to Java HashMap
(def clojure-map {:id 101 :name "Raghuveer"})

(def converted-java-map
  (java.util.HashMap. clojure-map))

(println "Clojure map:" clojure-map)
(println "Converted Java HashMap:" converted-java-map)

;; Converting Java Map to Clojure Map
(def converted-clojure-map
  (into {} java-map))

(println "Converted Clojure map:" converted-clojure-map)

(println "\n===== Program Completed Successfully =====")
