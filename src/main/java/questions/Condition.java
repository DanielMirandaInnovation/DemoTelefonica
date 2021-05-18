package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Condition implements Question<Boolean> {

    private Target element;

    public Condition(){}

    public Condition(Target element){
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WaitUntil.the(element, WebElementStateMatchers.isVisible());
        return element.resolveFor(actor).isVisible();
    }

    public static boolean conditionVisible(Actor actor,Target element) {

        if(element.resolveFor(actor).isVisible()){
            return true;
        }else{
            return false;
        }

    }
}

