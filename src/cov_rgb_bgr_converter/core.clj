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

(defn path-name ; designs the path name for anything
  [folder-dir  ; where we want to export too
  img-name     ; resource img-name
  filter-name]  ; if we want to add info at the end -inv (inverse) -gr (gray scale) etc. 
  (str folder-dir (get-file-name img-name) "-" filter-name "." (get-file-type img-name))
)

(defn resize-image-export
  [folder-dir   ; where we want to export too
  img-name      ; resource img-name
  width height] ; to rescale a image width x height
  (mikera.image.core/write
      (mikera.image.core/resize (load-image-resource img-name) width height)
      (str folder-dir "-resized" width "x" height "." (get-file-type img-name))
      (get-file-type img-name)
      :progressive true :quality 1.0)
)

(defn invert-image-export
  [folder-dir ; where we want to export too
  img-name]   ; resource img-name
    (mikera.image.core/write
      (filter-image (load-image-resource img-name) (mikera.image.filters/invert))
      (path-name folder-dir img-name "-inv") ;exports/img-name-inv.png
      (get-file-type img-name)
      :progressive true :quality 1.0)
)

(defn grayScale-image-export
    [folder-dir ; where we want to export too
    img-name]   ; resource img-name
    (mikera.image.core/write
        (filter-image (load-image-resource img-name) (mikera.image.filters/grayscale))
        (path-name folder-dir img-name "-gr") 
        (get-file-type img-name)
        :progressive true :quality 1.0)
)

(defn isPng?
  "Map across a folder - only get the png images"
  [img-name] 
  (not (= "png" (get-file-type img-name)))
)

(defn grab-list-filenames
  ; will remove all images if it isn't a png - then will shuffle the order.
  [files-txt]
  (remove isPng? (str/split (slurp files-txt) #"\n"))
)

(defn grayscale-resize
  "bread and butter of this project, take a path name of the image
   we are trying to get too ->"
  [folder-dir ; where we want to export too
   img-name   ; resource img-name
   img-size]  ; what we want the image to be rescaled too
  (def grayscale-img (filter-image (load-image-resource img-name) (mikera.image.filters/grayscale)))
  (mikera.image.core/write (mikera.image.core/resize grayscale-img img-size img-size) (path-name folder-dir img-name "") (get-file-type img-name) :progressive true :quality 1.0)
)

(defn build-folder
  [folder-dir
   target-image-size
   files] ; list of the files we want to process
   (doseq [file-names files] 
          (grayscale-resize folder-dir file-names target-image-size))
)

(defn build-image-data
  "Creme of la creme - we have prepared the data files :)"
  [train-dir 
  test-dir
  target-image-size
  files]
  (def shuffle-data (shuffle (grab-list-filenames files))) ; shuffle the data
  (def count-of-midpt (/ (count (grab-list-filenames files)) 2 )) ;calculate the midpoint
  (build-folder train-dir target-image-size (first (partition count-of-midpt shuffle-data))) ; take the first half
  (build-folder test-dir target-image-size (last (partition count-of-midpt shuffle-data))) ; take the second half
)

(defn make-copy-image
  "only works on jpgs"
  [folder-dir ; where we want to send the copies too
  img-name]   ; resource image name
  (mikera.image.core/write (mikera.image.core/load-image-resource img-name)  (path-name folder-dir img-name "-copy") (get-file-type img-name)  :progressive true :quality 1.0) 
)

(defn -main
  " 
    BUGS:
    Doesn't work for jpg's

    TODO (extra stuff):

    DONE:
    MAP across a folder - convert all images to gray scale DONE
    Parse through the image DONE
    Invert the pixels DONE 
    Export it as a new photo or image DONE
    Preparing training data to look at DONE

    Resources:
    https://cljdoc.org/d/net.mikera/imagez/0.12.0/api/mikera.image.dither#greyscale-palette-function
  "
  [& args]

  ;Examples of usage
  ;build-folder "train-dir/" 52 (grab-list-filenames "src/cov_rgb_bgr_converter/paths.txt"))
  (build-image-data "train-dir/" "test-dir/" 52 "src/cov_rgb_bgr_converter/paths.txt")
)
