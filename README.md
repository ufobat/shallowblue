# Board Movements
### Gegeben

1. Move( from -> to )
2. listOf( Pieces in White )
3. listOf( Pieces in Black )
4. listOf( Moves )

## Vorgehen
1) Wer ist dran?
2) Ist Move.from in listOf( Pices in $der_richtigen_farbe )?  
   => Piece

3) Is Move in Piece.pseudoLegalMoves()  
   PseudoLegalMoves respektieren Steine die im Weg sind, Beider Farben!  
   Aka: Alles was *gerade* rum steht, die jetzige Situation, wird berücksichtig.

4) Prüfen ob der Zug wirklich gültigt ist und Ausführung.  
   Aka: Alles was *vorher* passert ist, vorausgehende Züge also, werden berücksichtigt.

   * Castleing  
     Vorbedingungen *König* ist Unberührt, Turm ist unberührt!  
     Dann: Doppeltzug. Wenn der König sich bewegt muss auch der Turm Sich bewegen.

   * En passant  

     Vorbedingung: 
     * Das Feld auf dem der *Bauer* sich bewegt ist leer. 
     * Das Feld eines weiter ist von einem *gegnerischen Bauern* besetzt.
     * Der letzt zug hat ein *Weite von 2 Rows*
    
      Dann: Der Bauer zieht auf ein leeres feld, der *gegnerische Bauer* wird entfernt.

   * Promotion  
     Vorbedingung: Bauern zug auf den Rand.  
     Dann: Umwandlung in eine Figur deiner Wahl (kein König, Kein Bauer) 

   * Normaler Angriff  
     Vorbedingung: auf der Position Move.to() befindet sich ein Stein.  
     Dann: Stein wird gelöscht. -> Ausführung von einem Normalen Move

   * Normaler Move  
   Vorbedingungen: auf der Position Move.to() befindet sich *kein* Stein

## Nach dem Move
Eine Figur könnte gepinnt sein. Das lässt sich Prüfen ob *nach* dem move bei der Evaluierung des
Brettes ein Matt raus kommt.

## Anforderungen an den Move
  Wie bei der Schachnotation (e2e4 - Normal, e7e8q - Promotion, e1c1 - Castlein)
  * von Position
  * nach Position
  * Promotion in SteinType (or null)

```
	Move.from()
	Move.to()
	Move.promoteTo()
```
