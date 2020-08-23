package entities;

import java.util.Arrays;
import java.util.List;

public class MetalsAndColorsForm {

    private String oddRadioButton;
    private String evenRadioButton;
    private String[] elementsCheckBoxes;
    private String colorsDropDownValue;
    private String metalsDropDownValue;
    private String[] vegetablesDropDownCheckBoxes;

    public static class FormBuilder {

        private String oddRadioButton = "1";
        private String evenRadioButton = "2";
        private String[] elementsCheckBoxes;
        private String colorsDropDownValue = "Colors";
        private String metalsDropDownValue = "Metals";
        private String[] vegetablesDropDownCheckBoxes = {"Vegetables"};

        public FormBuilder setOddRadioButton(String oddRadioButton) {
            this.oddRadioButton = oddRadioButton;
            return this;
        }

        public FormBuilder setEvenRadioButton(String evenRadioButton) {
            this.evenRadioButton = evenRadioButton;
            return this;
        }

        public FormBuilder setElementsCheckBoxes(String... elementsCheckBoxes) {
            this.elementsCheckBoxes = elementsCheckBoxes;
            return this;
        }

        public FormBuilder setColorsDropDownValue(String colorsDropDownValue) {
            this.colorsDropDownValue = colorsDropDownValue;
            return this;
        }

        public FormBuilder setMetalsDropDownValue(String metalsDropDownValue) {
            this.metalsDropDownValue = metalsDropDownValue;
            return this;
        }

        public FormBuilder setVegetablesDropDownCheckBoxes(String... vegetablesDropDownCheckBoxes) {
            this.vegetablesDropDownCheckBoxes = vegetablesDropDownCheckBoxes;
            return this;
        }

        public MetalsAndColorsForm build() {
            return new MetalsAndColorsForm(this);
        }

    }

    private MetalsAndColorsForm(FormBuilder builder) {
        this.oddRadioButton = builder.oddRadioButton;
        this.evenRadioButton = builder.evenRadioButton;
        this.elementsCheckBoxes = builder.elementsCheckBoxes;
        this.colorsDropDownValue = builder.colorsDropDownValue;
        this.metalsDropDownValue = builder.metalsDropDownValue;
        this.vegetablesDropDownCheckBoxes = builder.vegetablesDropDownCheckBoxes;
    }

    public String getOddRadioButton() {
        return oddRadioButton;
    }

    public String getEvenRadioButton() {
        return evenRadioButton;
    }

    public String[] getElementsCheckBoxes() {
        return elementsCheckBoxes;
    }

    public String getColorsDropDownValue() {
        return colorsDropDownValue;
    }

    public String getMetalsDropDownValue() {
        return metalsDropDownValue;
    }

    public String[] getVegetablesDropDownCheckBoxes() {
        return vegetablesDropDownCheckBoxes;
    }

    public List<String> getValuesList() {
        List<String> values = Arrays.asList(
                Integer.toString(Integer.parseInt(getOddRadioButton()) + Integer.parseInt(getEvenRadioButton())),
                Arrays.toString(getElementsCheckBoxes())
                        .replace("[", "")
                        .replace("]", "")
                        .trim(),
                getColorsDropDownValue(),
                getMetalsDropDownValue(),
                Arrays.toString(getVegetablesDropDownCheckBoxes())
                        .replace("[", "")
                        .replace("]", "")
                        .trim());
        values.remove(null);
        return values;
    }

    @Override
    public String toString() {
        return "MetalsAndColorsForm{" +
                "oddRadioButton='" + oddRadioButton + '\'' +
                ", evenRadioButton='" + evenRadioButton + '\'' +
                ", elementsCheckBoxes=" + Arrays.toString(elementsCheckBoxes) +
                ", colorsDropDownValue='" + colorsDropDownValue + '\'' +
                ", metalsDropDownValue='" + metalsDropDownValue + '\'' +
                ", vegetablesDropDownCheckBoxes=" + Arrays.toString(vegetablesDropDownCheckBoxes) +
                '}';
    }
}
