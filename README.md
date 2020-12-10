# cov-rgb-bgr-converter

FIXME: description

## Installation

In the near future usage will be soon available on dc9.x10host.com

## Usage

FIXME: explanation

<<<<<<< HEAD
    - jpg images don't work - return empty images at attempted usage
      w/ mikera library when trying to apply filters.
    - code looks ugly.  
    - implement it into the backend 
    - kyle mueller -> GPU access
=======
   - .jpg images don't work - return empty images at attempted usage
      w/ mikera library when trying to apply filters.
   - code looks ugly.  
   - only one export folder can be used - will add option so that user
     can store images in  different directories
>>>>>>> 61dd5f22fb0fba9c82fdac00a61a896c8051259c

## Options

   - Will take .png images only for filters.

## Examples
-    Examples of usage in -main (see core.clj inside src/)
      
    display-image-invert-export "ant-2.jpg")
    (make-copy-image "ant.png)
    (grayScale-image-export "ant.png")
    (build-image-data "train-dir/" "test-dir/" 52 "src/cov_rgb_bgr_converter/paths.txt")

<<<<<<< HEAD
### Directions
PREREQS
Have a paths.txt file that has all of your file names

Drag images you want to be prepared into resources/
Clear out the test-dir and the train-dir, and run core.clj using lein run. 
See images into trained and test directories
=======
      ;Examples of usage in -main (see core.clj inside src/cov_rgb_bgr_converter/)
      (display-image-invert-export "ant-2.jpg")
      (make-copy-image "ant.png")
      (grayScale-image-export "ant.png")

### TODO
   - MAP across a folder - convert all images to gray scale (TODO)
   - Preparing training data to look at
>>>>>>> 61dd5f22fb0fba9c82fdac00a61a896c8051259c

### TODO
- Implement it into a command line **BIG**
    - We want to automate the process -> 
      we want to be able to drag in any type of data set (nCov, dog and cat pictures, etc. )
        mkdir /test-nCov-test ... or future /test-[insert-data-set-name]
    - RESTFUL API
    - train the sucka
    - show results
    - Optional: create an autoupdate for paths.txt.
        - for instance, when user drags in a dataset into resources folder
           a paths.txt should be generated.

        
### DONE
<<<<<<< HEAD
- Parse through the image DONE
- Invert the pixels DONE 
- Export it as a new photo or image DONE
- doseq across a folder - convert all images to gray scale DONE
- Preparing training data to look at DONE

### Bugs
- jpg's won't allow filters 

### Any Other Sections / Sources
- dc9.x10host.com
- I want to implement this functionality into my website
- https://cljdoc.org/d/net.mikera/imagez/0.12.0/api/mikera.image.dither#greyscale-palette-function
- https://drive.google.com/drive/folders/1kBer7h7ljCbCHqcyUikH0fisPEFGDV0e?usp=sharing (COVID-19 images/resources)

### That You Think
- project will serve as a baseline to how to convert any image
   into grayscale. Will take in directories, check if image is a .png
   will do everything to prepare data for ML.
- generalized parameters -> user only has to drag images library into
   resources folder
- create a script that will update paths.txt? 

### Might be Useful
- prepare.clj (we want to prepare nCov-2019 images soon - will serve as an example)
- more COVID-CT images (have a libary of images stored offsite and in Google drive)
=======
   - Parse through the image DONE
   - Invert the pixels DONE 
   - Export it as a new photo or image DONE

### Bugs
   - jpg's won't allow filters 

### Any Other Sections / Sources
   - dc9.x10host.com
   - https://cljdoc.org/d/net.mikera/imagez/0.12.0/api/mikera.image.dither#greyscale-palette-function
   - https://drive.google.com/drive/folders/1kBer7h7ljCbCHqcyUikH0fisPEFGDV0e?usp=sharing (COVID-19 images/resources)

### That You Think
   - project will serve as a baseline to how to convert any image
     into grayscale. Will take in directories, check if image is a .png
     will do everything to prepare data for ML>

### Might be Useful
   - prepare.clj (we want to prepare nCov-2019 images soon - will serve as an example)
   - more COVID-CT images (have a libary of images stored offsite and in Google drive)
>>>>>>> 61dd5f22fb0fba9c82fdac00a61a896c8051259c

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
