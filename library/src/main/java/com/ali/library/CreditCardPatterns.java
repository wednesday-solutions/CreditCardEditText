package com.ali.library;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kauserali on 05/05/14.
 */
public class CreditCardPatterns implements CreditCardEditText.CreditCartEditTextInterface {

    private Context mContext;

    public CreditCardPatterns(Context context) {
        mContext = context;
    }

    @Override
    public List<CreditCardEditText.CreditCard> mapOfRegexStringAndImageResourceForCreditCardEditText(CreditCardEditText creditCardEditText) {
        List<CreditCardEditText.CreditCard> listOfPatterns = new ArrayList<CreditCardEditText.CreditCard>();
        CreditCardEditText.CreditCard visa = new CreditCardEditText.CreditCard("^4[0-9]{12}(?:[0-9]{3})?$", mContext.getResources().getDrawable(R.drawable.visa), CreditCardTypeEnum.VISA.cartType);
        CreditCardEditText.CreditCard mastercard = new CreditCardEditText.CreditCard("^5[1-5][0-9]{14}$", mContext.getResources().getDrawable(R.drawable.mastercard), CreditCardTypeEnum.MASTER_CARD.cartType);
        CreditCardEditText.CreditCard amex = new CreditCardEditText.CreditCard("^3[47][0-9]{13}$", mContext.getResources().getDrawable(R.drawable.amex), CreditCardTypeEnum.AMERICAN_EXPRESS.cartType);

        listOfPatterns.add(visa);
        listOfPatterns.add(mastercard);
        listOfPatterns.add(amex);
        return listOfPatterns;
    }
}