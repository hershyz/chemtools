<img src="https://raw.githubusercontent.com/hershyz/chemtools/master/assets/logo.png"/>
<h3>Chemistry tools in a command line interface.</h3>
<p>The Chemtools CLI helps perform stoichiometry, limiting reactant, and mole calculations.</p>

<br>

<h4>Valid Commands:</h4>
<pre>
  help:                       Shows all available commands.
  exit:                       Closes the shell.
  lookup (symbol):            Looks up the information of an element.
  palookup (name):                                Looks up the information of a polyatomic ion.
  mm (symbol):                                    Finds the molar mass of a compound.
  moles (symbol, grams):                          Converts grams of a substance to moles.
  lr:                                             Limiting reactant calculator between two compounds with mole ratios.
  se (energy change, mass, temperature change):   Calculates the specific heat of a substance.
</pre>

<br>

<h4>Examples with Outputs:</h4>
<pre>
  > lookup H
  Element:        Hydrogen
  Atomic Number:  1
  Atomic Mass:    1.008
</pre>
<pre>
  > palookup phosphate
  Name:     Phosphate
  Formula:  PO4
  Charge:   -3
</pre>
<pre>
  > mm 1N 3H
  17.031 g/mol
</pre>
<pre>
  > moles 1Na 1Cl 180.91
  3.095653661875428
</pre>
<pre>
  > lr
  compound 1:     1C 3H
  compound 2:     2O
  mass (grams) 1: 50.84
  mass (grams) 2: 30.44
  mole ratio 1:   1
  mole ratio 2:   2
  lr: 2O
</pre>
<pre>
  > se 4402.7 50.29 10
  8.754623185523961
</pre>

<br>

<h4>Running:</h4>
<pre>java -jar chemtools.jar</pre>
