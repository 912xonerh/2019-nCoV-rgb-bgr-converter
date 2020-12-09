(ns cov-rgb-bgr-converter.core
  (:gen-class))


(use 'mikera.image.core)
(use 'mikera.image.filters)

(require '[clojure.string :as str])
(require '[mikera.image.filters :as filt])
(require '[clojure.java.io :as io])
(require '[clojure.java.io :refer [resource]])

(defn display-image
  [img-name]
  (show (load-image-resource img-name))
)

(defn invert-image
  [img-name]
  (show (filter-image (load-image-resource img-name) (mikera.image.filters/invert)))
)

(defn get-file-type
[img-name]
  (last (str/split img-name #"\."))
)

(defn get-file-name
  [img-name]
  (first (str/split img-name #"\."))
)

(defn isPng?
  "Map across a folder - only get the png images"
  [img-name]
  (= "png" (get-file-type img-name))  
)

(defn resize-image-export
  [img-name width height]
  (mikera.image.core/write
      (mikera.image.core/resize (load-image-resource img-name) width height)
      (str "exports/" (get-file-name img-name) "-resized" width "x" height "." (get-file-type img-name))
      (get-file-type img-name)
      :progressive true :quality 1.0)
)

(defn invert-image-export
  [img-name]
    (mikera.image.core/write
      (filter-image (load-image-resource img-name) (mikera.image.filters/invert))
      (str "exports/" (get-file-name img-name) "-inv." (get-file-type img-name))
      (get-file-type img-name)
      :progressive true :quality 1.0)
)

(defn grayScale-image-export
    [img-name]
    (mikera.image.core/write
        (filter-image (load-image-resource img-name) (mikera.image.filters/grayscale))
        (str "exports/" (get-file-name img-name) "-gr." (get-file-type img-name))
        (get-file-type img-name)
    :progressive true :quality 1.0)
)

(defn make-copy-image
  "only works on jpgs"
  [img-name]
  (mikera.image.core/write 
      (mikera.image.core/load-image-resource img-name)  ; loaded from resources folder
      (str "exports/" (get-file-name img-name) "-copy." (get-file-type img-name))  ; put copy in export folder
      (get-file-type img-name)  ; get the file type ending for us
      :progressive true :quality 1.0) ; optional parameters
)


(defn -main
  " 
    BUGS:
    Doesn't work for jpg's

    TODO (extra stuff):
    MAP across a folder - convert all images to gray scale (TODO)
    Preparing training data to look at

    DONE:
    Parse through the image DONE
    Invert the pixels DONE 
    Export it as a new photo or image DONE

    Resources:
    https://cljdoc.org/d/net.mikera/imagez/0.12.0/api/mikera.image.dither#greyscale-palette-function
  "
  [& args]
  ;Examples of usage
  ;(display-image-invert-export "ant-2.jpg")
  ;(make-copy-image "ant.png)
  ;(grayScale-image-export "ant.png")
)
