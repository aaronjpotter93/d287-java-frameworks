# Receipt Splitter App
### D287 – JAVA FRAMEWORKS

### This App includes the following features:
* Create a grocery shopping list 
* Create and buy meal bundles that are simply packaged items needed for that meal.

## Change Log for Steps C -> J

### Step C
#### Prompt:
_Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts_
#### Changes:
* > templates >
  * > confirmaddpart.html
  * > confirmaddproduct.html
  * > confirmassocpart.html
  * > confirmdeletepart.html
  * > confirmdeleteproduct.html
  * > negativeerror.html
  * > saveproductscreen.html
    * Line: 4
      * Added \<link stylesheet>
      * This was so that for the half second that the page is refreshing the background stays a dark color
* > templates >
  * > InhousePartForm.html
      * Line: 8
        * Added \<link stylesheet>
      * Lines 12 - 25
        * added a navbar
      * Lines 29 - 32
        * added a new div container for \<h1> tag for styling purposes
      * Line 50
        * added classes to the submit button for styling
      * Lines 52 - 63
        * added javascript for animation styling purposes
  * > OutsourcedPartForm.html
      * Line: 8
        * Added \<link stylesheet>
      * Lines 12 - 25
        * added a navbar
      * Lines 29 - 32
        * added a new div container for \<h1> tag for styling purposes
      * Line 50
        * added classes to the submit button for styling
      * Lines 52 - 63
        * added javascript for animation styling purposes
  * > mainscreen.html
      * Line: 8
          * Added \<link stylesheet>
      * Line: 9
          * Changed App \<title> to "Online Grocery Shopping"
      * Lines 12 - 25
          * added a navbar
      * Lines 29 - 32
          * added a new div container for \<h1> tag for styling purposes
      * Lines 110 - 135
          * added javascript for animation styling purposes
  * > productForm.html
    * Line: 8
        * Added \<link stylesheet>
    * Lines 12 - 25
      * added a navbar
    * Lines 29 - 32
      * added a new div container for \<h1> tag for styling purposes
    * Line 50
      * added classes to the submit button for styling
    * Lines 95 - 105
      * added javascript for animation styling purposes
* > resources > static > css > demo.css
  * All Lines
      * added styles for all pages


### Step D
#### Prompt:
_Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen._
#### Changes:
* ### controllers >
    * > AboutController.java
        * Added new file
* ### resources > templates >
    * > About.html
        * Added new file

### Step E
#### Prompt:
_Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database._
#### Changes:
* ### resources > 
  * > application.properties
      * #FIXME * swapped "update" for "create-drop" for testing
* ### bootstrap > 
  * > BootStrapData
      * Lines 43 - 184
          * Cleaned up original commented out bootstrap for bicycles
          * Added InhousePart bootstrap instances
          * Added Product boostrap instances
### Step F
#### Prompt:
_Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:_
*  _The “Buy Now” button must be next to the buttons that update and delete products._
*  _The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts._
*  _Display a message that indicates the success or failure of a purchase._
#### Changes:
* ### controllers > 
  * > AddProductController
    * Line 5
      * Added import for ProductRepository
    * Lines 35 - 38
      * Autowired ProductServiceImpl and ProductRepository
    * Lines 181 - 196
      * Added new method to handle "Buy Now" button
* ### resources > templates
  * > mainscreen.html
    * Line 99
      * Added "Buy Now" button
  * > Success.html
  * > Failure.html
    * Added two new view pages
### Step G
#### Prompt:
_Modify the parts to track maximum and minimum inventory by doing the following:_
*  _Add additional fields to the part entity for maximum and minimum inventory._
*  _Modify the sample inventory to include the maximum and minimum fields._
*  _Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values._

[//]: # (* FIXME * What does this mean? rename the repository?)
*  _Rename the file the persistent storage is saved to._ 
*  _Modify the code to enforce that the inventory is between or at the minimum and maximum value._
#### Changes:
* ### bootstrap >
  * > BootStrapData
    * Line 44
      * Changed Beef from an Inhouse Part to an Outsourced Part
    * Lines 49 - 194
      * Set min and max inventory for each sample part
* ### domain >
  * > Part
    * Lines 4 - 5
      * import ValidPartInventory & ValidMaxInv validators
    * Lines 21 - 22
      * annotate class with ValidPartInventory & ValidMaxInv
    * Lines 36 - 39
      * two new fields for entity - maxInv, minInv(annotated with @Min)
    * Lines 94 - 109
      * getters and setters for minInv, maxInv
* ### validators >
  * > ValidPartInventory
  * > ValidMaxInv
    * Added two new annotations
  * > PartInventoryValidator
  * > MaxInvValidator
    * Added two new validators
* ### resources > templates >
  * > InhousePartForm
    * Lines 48 - 53
      * Added two new input fields for minIn & maxInv
    * Lines 56 - 64
      * Added lines for printing new validator error messages
  * > OutsourcedPartForm
  * Lines 45 - 51
      * Added two new input fields for minIn & maxInv
  * Lines 56 - 64
      * Added lines for printing new validator error messages
### Step H
#### Prompt:
_Add validation for between or at the maximum and minimum fields. The validation must include the following:_
*  _Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts._
*  _Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum._
*  _Display error messages when adding and updating parts if the inventory is greater than the maximum._
#### Changes:
* ### controllers > 
  * > AddProductController 
    * Lines 62 - 92
      * refactored post handler for error binding to maintain form input
* ### validators >
  * > EnufPartsValidator
    * Line 36
      * Increased comparable operator by the minInv amount
* ### resources > templates
  * >  mainscreen.html
    * Lines 54 - 55
      * Added Min & Max <th> values
    * Lines 64 - 65
      * Added Min & Max <td> values
#### Style Changes: 
  * ### resources > templates
    * > InhousePartForm.html
      * Lines 39 - 75
        * Added span tag to style the form field placeholder values
    * > InhousePartForm.html
      * Lines 39 - 75
        * Added span tag to style the form field placeholder values
    * > negativeerror.html
      * Lines 4 - 7
        * style imports
      * Lines 11 - 25
        * added navbar
      * Lines 26 - 31
        * styling body text
      * Lines 33 - 61
        * added navbar and redirect scripts

### Step I
#### Prompt:
_
#### Changes:
* ###
### Step J
#### Prompt:
_
#### Changes:
* ###

## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!
