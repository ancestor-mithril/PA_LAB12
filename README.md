# PA_LAB12

## Compulsory {
1. Create the class MainFrame of type JFrame, that will also represent the main class of the application. The frame will contain a ControlPanel in the north and a DesignPanel in the center.
    * Au fost create toate aceste 3 clase in pachetul frame
2. The ControlPanel will allow the user to specify any class name of a Swing component (such as javax.swing.JButton, javax.swing.JLabel, etc.), a default text for that component (if applicable) and a button for creating and adding an instance of the specified component to the DesignPanel.
    * Aceasta clasa are 2 TextField-uri pentru introdus tipul si numele clasei
    * 2 Labeluri care descriu cele 2 textfielduri
    * un buton de creare a unei noi componente swing
        * acest buton odata apasat declanseaza un eveniment de creare a unei noi componente
        * la momentul apasarii, se obtin cele 2 valori de tip String din cele 2 textField-uri
        * prima reprezinta numele clasei, si se incearca exact ca in curs ***Class.forName***
        * daca reuseste operatia, se creaza o componenta **Component** cu *newInstance*
        * se verifica daca aceasta componenta este o instanta de Label, Buttton, TextField, TextArea, pentru a i se adauga un nume daca este cazul
        * este adaugata in DesignPanel, fie ca Componenta, fie ca JLabel, JButton, JTextArea sau JTextField
    * un Label pentru afisarea unei eventuale erori
3. The DesignPanel represents a simple JPanel, using absolute positioning of its components and containing Swing components added by our application.
    * in design panel se creaza o imagine alba pe care se face design-ul, exact ca in laboratorul 6
    * positionarea absoluta se realizeaza cu ajutorul unui vector de componente
    * dupa numarul elementelor din vectorul de componente, se face setBounds la fiecare componenta in parte
    * in plus se seteaza layout-ul null pentru a nu afecta positionarea absoluta
## }
