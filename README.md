# cov-rgb-bgr-converter

FIXME: description

## Installation

In the near future
usage will be soon available on dc9.x10host.com

## Usage

FIXME: explanation

    - .jpg images don't work - return empty images at attempted usage
      w/ mikera library when trying to apply filters.
    - code looks ugly.  
    - only one export folder can be used - will add option so that user
      can store images in  different directories

## Options

   - Will take .png images only for filters.

## Examples

    - Examples of usage in -main (see core.clj inside src/)
      (display-image-invert-export "ant-2.jpg")
      (make-copy-image "ant.png)
      (grayScale-image-export "ant.png")

### TODO
    - MAP across a folder - convert all images to gray scale (TODO)
    - Preparing training data to look at

### DONE
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
