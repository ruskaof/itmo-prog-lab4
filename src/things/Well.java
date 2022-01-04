package things;

import abstractThings.Narrator;
import exceptions.NegativeAmountOfLiquidInPitException;

public abstract class Well {
    protected Pit pit;

    Well(Pit pit) {
        this.pit = pit;
    }

    public static class Pit{
        public Pit(double liquidAmount){
            this.liquidAmount = liquidAmount;
        }

        private double liquidAmount;
        public double getLiquidAmount(){
            return liquidAmount;
        }
        public void setLiquidAmount (double liquidAmount) throws NegativeAmountOfLiquidInPitException {
            if (liquidAmount < 0)
                throw new NegativeAmountOfLiquidInPitException("You can't set a negative number to liquidAmount");
            this.liquidAmount = liquidAmount;
        }
    }

    public void getLiquid(double amount) {
        try{
            pit.setLiquidAmount(pit.getLiquidAmount() - amount);
            Narrator.tell("The Well now has less liquid, got it successfully.");
        }
        catch (NegativeAmountOfLiquidInPitException e){
            Narrator.tell("Well, well did not have enough liquid.");
        }
    }
}
