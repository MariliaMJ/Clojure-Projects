(ns small-projects.csv-to-md
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn parse-csv! [file]
  (let [lines (->> (io/reader file)
                   line-seq)
        parse-line #(str/split % #",")]
    (map parse-line lines)))

(defn content
  []
  (str "---\n"
       "Author: "(nth entry 2) "\n"
       "Status: " (first entry) "\n"
       "Date-Read: " (nth entry 3) "\n"
       "Type: " (nth entry 4) "\n"
       "---\n\n"
       "- Metadata:\n"
       "- **Author:** `= this.Author`\n"
       "       - **Status:** `= this.Status`\n"
       "       - **ISBN:** `= this.ISBN`\n"
       "       - **Date-Read:** `= this.Date-Read`\n\n"))

(defn write-md-file!
  [entry]
  (let [dir-path "/Users/marilia.morais/dev/study/Books/"
        file-name (str dir-path (second entry) ".md")
        file (io/file file-name)
        content (content)]

    (.mkdirs (.getParentFile file))
    (spit file content)
    (println "File written successfully!" file-name)))

(defn map-csv-row-to-md-file [entry]
  (let [entry (vec entry)]
    (write-md-file entry)))

(defn process-csv! [file]
  (map map-csv-row-to-md-file (parse-csv file)))
