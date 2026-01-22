// The Tin Woodman
// CSE 143: 
// Assignment #2
// 4-10-12

// This class creates a new Guitar with  different strings using all the methods that
// GuitarLite contains. Allows the user to play notes starting at concert A and
// 36 other notes following concert A.

public class Guitar37 implements Guitar {
   private GuitarString[] guitar37Strings;    
   public static final String KEYBOARD =
      "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout

// Constructs a guitar with different strings
   public Guitar37() {
      guitar37Strings = new GuitarString[37];
      for (int i = 0; i < guitar37Strings.length; i++) {
          guitar37Strings[i] = new GuitarString(440 * Math.pow(2, (i - 24.0) / 12.0)); 
                                                // frequency of note
      }
   }

// Returns true if there is a guitar string that corresponds to this character, 
// otherwise returns false.
   public boolean hasString(char string) {
      for (int i = 0; i < KEYBOARD.length(); i++) {
         if (string == KEYBOARD.charAt(i))
            return true;
      }
      return false;
   }

// plucks the string for the passed character. throws IllegalArgumentException if pressed
// letter is not in the KEYBOARD.
   public void pluck(char string) {
      int index = KEYBOARD.indexOf(string);
      guitar37Strings[index].pluck();
//       for (int i = 0; i < KEYBOARD.length(); i++) {   
//          (KEYBOARD.charAt(i) != string)
//             throw new IllegalArgumentException();
//       }
   
   }

// plays the current note(s)
   public void play() {
      double sample = 0.0;
      for (int i = 0; i < KEYBOARD.length(); i++) {
         sample += guitar37Strings[i].sample();
      }
      StdAudio.play(sample);
   }
   
// advances simulation by having each string tic forward
   public void tic() {
      for (int i = 0; i < guitar37Strings.length; i++)
         guitar37Strings[i].tic();
   }
}
