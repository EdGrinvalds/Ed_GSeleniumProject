1. The Edureka site this weekend started displaying an ad popup.When navigating between pages,
clicking on certain buttons, etc. It is unknown when this dialog popup will occur.
Please see the PNG pic with filename "SpuriousAvailOfferPopup.PNG" enclosed in this package.
It is not an alert, but a popup dialog. Testing to see after each navigation or click if
the spurious dialog appears is not done in this script for class session module 5.

2. Further, a custom class and method for waiting for page condition to be "complete"
by polling was also created and used which made the script more robust since the
wait.until(ExpectedConditions.presenceOfElementLocated() and the
wait.until(ExpectedConditions.elementToBeClickable() explicit waits did not always
work either.

Please ensure this WaitForPageLoadComplete.java class file is in the path
so it is resolvabled in the main() script.

3. The script has only one Thread.sleep that is actually uncommented as all efforts to
use explicit waits and the custom wait page mentioned in item 2. above to make sure the
Login dialog popup was ready for the sendKeys to the dialog's username textbox were not
successful.  