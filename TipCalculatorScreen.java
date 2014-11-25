package tipcalculator;

import android.widget.TextView;
import android.widget.EditText;
import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Joe
 * @version 2012.09.14
 */
public class TipCalculatorScreen
    extends Screen
{
    // ~ Fields ................................................................

    private TipCalculator tipCaclulator;
    private EditText      amountOfBill;
    private TextView      tipAmount;


    // ~ Public methods ........................................................

    /**
     * Initialize the fields and set up the application.
     */
    public void initialize()
    {
        tipCaclulator = new TipCalculator();
        tipCaclulator.addObserver(this);
        tipCaclulator.setTipRate(0.15);
    }


    /**
     * Process when the tip15 radio button is clicked.
     */
    public void tip15Clicked()
    {
        tipCaclulator.setTipRate(.15);
    }


    /**
     * Process when the tip18 radio button is clicked.
     */
    public void tip18Clicked()
    {
        tipCaclulator.setTipRate(.18);
    }


    /**
     * Process when the tip20 radio button is clicked.
     */
    public void tip20Clicked()
    {
        tipCaclulator.setTipRate(.20);
    }


    /**
     * Set the amount when we're done calculating
     */
    public void amountOfBillEditingDone()
    {
        tipCaclulator.setAmountOfBill(Double.parseDouble(amountOfBill.getText()
            .toString()));
    }


    /**
     * React to a change in an observed class.
     *
     * @param t
     *            The observed TipCalculator
     */
    public void changeWasObserved(TipCalculator t)
    {
        tipAmount.setText(String.format("%.2f", t.getTipAmount()));
    }

}
