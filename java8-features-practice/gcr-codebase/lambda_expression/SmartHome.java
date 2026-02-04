package lambda_expression;

@FunctionalInterface
interface LightBehavior {
	void activate();
}

class SmartLightSystem {
	public void runTrigger(LightBehavior behavior) {
		behavior.activate();
	}
}

public class SmartHome {
	public static void main(String[] args) {

		SmartLightSystem system = new SmartLightSystem();

		LightBehavior motionTrigger = () -> System.out.println("Motion detected → Lights ON at 100% brightness");

		LightBehavior eveningTrigger = () -> System.out.println("Evening mode → Warm lights at 60% brightness");

		LightBehavior voiceTrigger = () -> System.out.println("Voice command → Blue ambient lights activated");

		system.runTrigger(motionTrigger);
		system.runTrigger(eveningTrigger);
		system.runTrigger(voiceTrigger);
	}
}
