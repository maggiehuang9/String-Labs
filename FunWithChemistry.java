
/**
 * FunWithChemistry
 *
 * @author Maggie Huang
 * @version 2/22/18
 */
public class FunWithChemistry
{
    private AtomicMassTable table = new AtomicMassTable();
    private double moleculeWeight;
    
    public FunWithChemistry()
    {
        //assign moleculeWeight to 0
        moleculeWeight = 0;
    }
    
    public FunWithChemistry(String molecule)
    {
       //assign value for moleculeWeight
       parseMolecule(molecule);
    }

     public double elementWeight(String element)
    {
        //this method takes a string of element and return atomic weight of element
        StringBuffer name= new StringBuffer("");  // for save element name
        StringBuffer number= new StringBuffer(""); // for save element number
        
        for (int i =0; i<element.length(); i++)
        {
            if ( Character.isLetter(element.charAt(i)) )
            {
                name.append(element.charAt(i));  // get the element name
            } 
            else if ( Character.isDigit(element.charAt(i)) )
            {
                number.append(element.charAt(i)); // get number of elements
            }
        }
        
        double weight=0;
        int num = 1;
        
        if (name.length()>0)  
            weight = table.get(name.toString());  // get elememt weight
        
        if (number.length()>0) 
            num = Integer.parseInt(number.toString()); // get number of elements
        
        return weight*num; // return toal weight
    }
    
     public void parseMolecule(String molecule)
    {
        // this method computes the weight of molecule and assigns it to moleculeWeight
        molecule = molecule.trim();  // trim leading and tailing space
        moleculeWeight = 0; //reset moleculeWeight to 0
        int index=0;  //set the index to the start index of first element

        for (int i=1; i<molecule.length(); i++)
        {
            if ( Character.isUpperCase(molecule.charAt(i)) ) // if start of next element
            {
                moleculeWeight += elementWeight(molecule.substring(index,i));
                index = i;   // set the index to the start index of next element
                // if last charater, add the weight for the last element
                if (index==molecule.length()-1) moleculeWeight += elementWeight(molecule.substring(index)); 
            }
            else if (!Character.isLetterOrDigit(molecule.charAt(i))) // if neither letter nor digit, assume end of molecule string
            {
                moleculeWeight += elementWeight(molecule.substring(index,i));
                break;
            }
            else if ( i==molecule.length()-1 )  // if end of string
            {
               moleculeWeight += elementWeight(molecule.substring(index,i+1)); 
            }
        }
    }
     
    public double getMoleculeWeight()
    {
        //return weight of molecule
        return moleculeWeight;
    }

    public double molesToGrams(double moles)
    {
        //takes in moles and converts to grams
        return moles*getMoleculeWeight();
    }
    
    public double gramsToMoles(double grams)
    {
        //takes in grams and converts to moles
        return grams/getMoleculeWeight();
    }
}

