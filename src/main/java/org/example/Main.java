package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        while (true) {
            int choice = inputReader.nextInt();
            inputReader.nextLine();

            switch (choice) {
                case 0:
                    inputReader.close();
                    return;

                case 1:
                    System.out.println(3+6);
                    break;

                case 2:
                    System.out.println(9+8);
                    break;

                case 3:

                    System.out.println(7+9);
                    break;

                case 4:
                    System.out.println(7+6);
                    break;

                case 5:

                    System.out.println(99+7);
                    break;

                default:
                    break;
            }
        }
    }
}
/*In Java, when you use nextInt() to read an integer from the input stream, it only reads the integer value and leaves the newline character (Enter key) in the input buffer. If you subsequently call nextLine() without consuming this newline character, it will read that newline character and consider it as an empty line. This can lead to unexpected behavior.

In the provided code:

java
Copy code
int choice = inputReader.nextInt();
inputReader.nextLine();
After reading the integer choice using nextInt(), inputReader.nextLine() is called to consume the newline character left in the buffer. This ensures that the next input operation (nextLine() or similar) doesn't accidentally consume the remaining newline character.

If you didn't include inputReader.nextLine(), and let's say you had another nextLine() or next() operation after reading the integer, it would immediately consume the newline character, potentially resulting in skipping user input or receiving unexpected input.

In summary, including inputReader.nextLine() after reading an integer using nextInt() is a common practice to handle the newline character left in the input buffer and prevent any unintended consequences in subsequent input operations.
* */


apiVersion: v1
kind: Secret
metadata:
  name: site-operator-demo-admin
  namespace: foundation-cluster-zerotrust
type: Opaque
stringData:
  secret: site-operator-demo-admin-secret
---
apiVersion: security.grid.digital.ge.com/v1beta1
kind: UaaClient
metadata:
  name: site-operator-demo-admin
  namespace: foundation-cluster-zerotrust
spec:
  secretName: site-operator-demo-admin
  accessTokenValidity: 36000 # Optional, time in seconds
  refreshTokenValidity: 72000 # Optional, time in seconds
  tokenSalt: fdijfos # Optional, default webhook will generate random string if value is empty
  authorities: # Mandatory
    - systemadmin
  authorizedGrantTypes: # Mandatory
    - client_credentials
