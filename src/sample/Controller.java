package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    public Label answer;
    public Slider one;
    public Slider two;
    public Slider three;
    public Label no;
    public Map<Integer, String> answers = new HashMap<>();
    public Map<Integer, Integer> results = new HashMap<>();
    public int i = 0;


    public void go(ActionEvent actionEvent) {
        String ans = String.format("%.0f", one.getValue()) + String.format("%.0f", two.getValue()) + String.format("%.0f", three.getValue());
        String realans = String.valueOf(results.get(i));
        System.out.println(ans+ "    " + realans);
        if (ans.equals(realans)){
            no.setVisible(false);
            i++;
            answer.setText(answers.get(i));
        }
        else {
            no.setVisible(true);
        }
    }

    public void createAnswers(ActionEvent actionEvent) {
        for (int i = 0; i<100; i++){
            int a = 1 + (int) (Math.random() * 499);
            int b = 1 + (int) (Math.random() * 499);
            answers.put(i, (a + "+" + b));
            results.put(i, (a+b));
        }
        answer.setText(answers.get(0));
    }
}
