CreditCardEditText
==================

## Introduction

This library is an extension of Android's EditText control. Its purpose is to detect the type of credit card from the numbers that are entered in it. It also provides an interface through which more patterns can be added. Once a pattern is found it displays the appropriate image next to the number.

![Default CreditCardEditText](https://raw.githubusercontent.com/aliHafizji/CreditCardEditText/master/example/default_creditcard_image.png)

![Visa](https://raw.githubusercontent.com/aliHafizji/CreditCardEditText/master/example/visa_credit_card_image.png)

![Mastercard](https://raw.githubusercontent.com/aliHafizji/CreditCardEditText/master/example/master_card_image.png)

![American express](https://raw.githubusercontent.com/aliHafizji/CreditCardEditText/master/example/american_express_image.png)

## Setup

### Method 1: Referencing library project

CreditCardEditText is created as a standalone Android-Library project. You can easily include this project by referencing the library/ folder in your project using either eclipse or Android studio

### Method 2: Adding a remote referece

The compiled version of the library is present on maven central. Using this method is easier than downloading the source and referencing it in your project. To add the library via a remote reference please follow these steps:

* Open the build.gradle file for the module that will use this control.
* At the root level add the following:

```
repositories {
    mavenCentral()
}
```

* In the dependancy section add the following reference:

```
dependencies {
    compile 'com.alihafizji.creditcardedittext:library:+@aar'
}
```
**Note: The dependacy section can have other dependencies**

* Select the "Sync project with Gradle files" button in Android studio or simply run the assembleDebug gradle task via command line.

## Customizations

By default this control detects the following card types:

* Visa
* American Express
* Mastercard

In case you want to support more types then simply create an object that implements the `CreditCardEditText.CreditCartEditTextInterface` interface and return a list of `CreditCardEditText.CreditCard` objects as shown below:

```java
public class CreditCardPatterns implements CreditCardEditText.CreditCartEditTextInterface {

    private Context mContext;

    public CreditCardPatterns(Context context) {
        mContext = context;
    }

    @Override
    public List<CreditCardEditText.CreditCard> mapOfRegexStringAndImageResourceForCreditCardEditText(CreditCardEditText creditCardEditText) {
        List<CreditCardEditText.CreditCard> listOfPatterns = new ArrayList<CreditCardEditText.CreditCard>();
        
        CreditCardEditText.CreditCard newCard = new CreditCardEditText.CreditCard("^4[0-9]{12}(?:[0-9]{3})?$", mContext.getResources().getDrawable(R.drawable.newcard), "newcard");
        

        listOfPatterns.add(newCard);
        return listOfPatterns;
    }
}
```

The `CreditCard` class has details about the regex pattern, image and a string identifier.

Once this class is ready all you need to do is to pass this object to the `CreditCardEditText` control. This is done using the `setCreditCardEditTextListener` method.

## Developed by

* Ali Hafizji <ali.hafizji@gmail.com>
[Follow me on twitter](https://twitter.com/Ali_hafizji).

## Credits

"credit_card" image by Brian Opplander, from the [noun project](nounproject.com) collection.
