import java.math.BigDecimal;
import java.math.BigInteger;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import milfont.com.tezosj.domain.Crypto;
import milfont.com.tezosj.helper.Global;
import milfont.com.tezosj.model.TezosWallet;

public class Main
{
   static String calculateHash(MessageDigest digest, File file) throws IOException{
    
      //Get file input stream for reading the file content
      FileInputStream fis = new FileInputStream(file);

      //Create byte array to read data in chunks
      byte[] byteArray = new byte[1024];
      int bytesCount = 0; 
        
      //Read file data and update in message digest
      while ((bytesCount = fis.read(byteArray)) != -1) {
        digest.update(byteArray, 0, bytesCount);
      };
      
      //close the stream; We don't need it now.
      fis.close();
      
      //Get the hash's bytes
      byte[] bytes = digest.digest();
      
      //This bytes[] has bytes in decimal format;
      //Convert it to hexadecimal format
      StringBuilder sb = new StringBuilder();
      for(int i=0; i< bytes.length ;i++)
      {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      //System.out.println(sb.toString());

      return sb.toString();
   }

   public static void walk(String path, Map<String, List<String>> map) throws NoSuchAlgorithmException, IOException{
      MessageDigest digest = MessageDigest.getInstance("SHA-256");

      File root = new File( path );
      File[] list = root.listFiles();

      if (list == null) return;
      int i = 0;
      for ( File f : list ) {
          i++;
          if ( f.isDirectory() ) {
              System.out.println( "Dir:" + f.getAbsoluteFile() );
              walk( f.getAbsolutePath() , map);
          }
          else {
              System.out.println( "File:" + f.getAbsoluteFile() );
              // System.out.print("File " +i +":");
              // System.out.println("" +f.getName());
              // System.out.println(calculateHash(digest, f.getAbsoluteFile()));
          }
          // System.out.print("File " +i +":");
          // System.out.println("" +f.getName());
          // System.out.println(calculateHash(digest, f.getAbsoluteFile()));
      }
   }
   public static void main(String[] args) throws Exception
   {

    Map<String, List<String>> map = new HashMap<>();
    //File file = new File("D:\\GitHub\\TezosJ\\TezosJ_plainJava\\bin");
    String pathString = "D:\\GitHub\\TezosJ\\TezosJ_plainJava\\FilesToHash";

    walk(pathString, map);

    //File file = new File("D:\\GitHub\\TezosJ\\TezosJ_plainJava\\FilesToHash\\WarehouseModel.xlsx");
    //MessageDigest digest = MessageDigest.getInstance("SHA-256");

    //String newHash = calculateHash(digest, file);
    //System.out.println(newHash);

    /*MessageDigest digest = MessageDigest.getInstance("SHA-256");

    File root = new File( "D:\\GitHub\\TezosJ\\TezosJ_plainJava\\FilesToHash" );
    File[] list = root.listFiles();

    if (list == null) return;
    int i = 0;
    for ( File f : list ) {
        i++;
        // if ( f.isDirectory() ) {
        //     walk( f.getAbsolutePath());
        //     System.out.println( "Dir:" + f.getAbsoluteFile() );
        // }
        // else {
        //     System.out.println( "File:" + f.getAbsoluteFile() );
        // }
        System.out.print("File " +i +":");
        System.out.println("" +f.getName());
        System.out.println(calculateHash(digest, f.getAbsoluteFile()));
    }*/

    //TezosWallet wallet1 = new TezosWallet("cube security region mouse wash holiday rural pass pretty assist anxiety movie stay success zebra", "CorboPassphrase");
    //wallet1.setProvider("https://rpc.ghostnet.teztnets.xyz");

    TezosWallet wallet3 = new TezosWallet("venue squirrel woman chimney increase tiger can wreck tag predict help board frown save net", 
                                          "CorboPassphrase3");
    wallet3.setProvider("https://rpc.jakartanet.teztnets.xyz");
    //System.out.println(wallet3.getPublicKeyHash());

    /*BigDecimal amount = new BigDecimal("0");
    BigDecimal fee = new BigDecimal("0.1");
    JSONObject jsonObject = wallet3.callContractEntryPoint(wallet3.getPublicKeyHash(), "KT1NR1DEWk6zRcKnqWG67bjSFdU1MdCHFijh", amount,
                                                            fee, "", "", "fileCheck",
                                                            new String[]{"WarehouseModel.xlsx", "0368942eeb2415ac23c09636b4b7b2afc487a0b95065e6bb3af137261eb304d7"}, false, Global.GENERIC_STANDARD);
    String opHash = (String) jsonObject.get("result"); 
    Boolean opHashIncluded = wallet3.waitForAndCheckResult(opHash, 4);
    System.out.println(opHashIncluded + " " + opHash);*/
    //System.out.println(wallet3.getContractStorage("KT1CHqUWjyuyYUi61ppqQ5n5R5NxTamVvtKk"));

    //ArrayList<Map> arrayList;

    //wallet3.waitForAndCheckResult(operationHash, numberOfBlocksToWait)

    //arrayList = wallet3.getContractStorage("KT1CHqUWjyuyYUi61ppqQ5n5R5NxTamVvtKk");

      /*
      */
      // Creates a new wallet with a passphrase.
      //TezosWallet wallet = new TezosWallet("CorboPassphrase2");
      //tz1T25UReWaaaZEfvpg3HFWKB3HoXt4EhgaS
      //String w1Key = "tz1T25UReWaaaZEfvpg3HFWKB3HoXt4EhgaS";
      //TezosWallet wallet1 = new TezosWallet("cube security region mouse wash holiday rural pass pretty assist anxiety movie stay success zebra", "CorboPassphrase");
      //tz1VsnrJhJgQvgbLWgAktfRScWNDGh6BmXdP
      //String w2Key = "tz1VsnrJhJgQvgbLWgAktfRScWNDGh6BmXdP";
      //TezosWallet wallet2 = new TezosWallet("farm slim athlete spin suggest creek taste select proof cram kingdom local sail manual afford", "CorboPassphrase2");
      //System.out.print("test45\n");
      //  wallet1.setProvider("https://rpc.ghostnet.teztnets.xyz");
      //System.out.println(wallet2.getPublicKeyHash());
      //System.out.println(wallet2.getMnemonicWords());
      //System.out.println(wallet2.getBalance());*/

      /*TezosWallet wallet3 = new TezosWallet("CorboPassphrase3");
      tz1UyUZgwgPmBG5DK5fKfdRxCjgVM4ELzYAS
      wallet3.setProvider("https://rpc.jakartanet.teztnets.xyz");
      System.out.println(wallet3.getMnemonicWords());*/

      /*TezosWallet wallet3 = new TezosWallet("venue squirrel woman chimney increase tiger can wreck tag predict help board frown save net", 
                                            "CorboPassphrase3");
      wallet3.setProvider("https://rpc.jakartanet.teztnets.xyz");
      System.out.println(wallet3.getPublicKeyHash());*/
      //System.out.println(wallet3.getBalance());

      /*BigDecimal amount = new BigDecimal("0");
      BigDecimal fee = new BigDecimal("0.1");
      JSONObject jsonObject = wallet1.callContractEntryPoint(wallet1.getPublicKeyHash(), "KT18cCwX5uaknByiMkbniTdsFN41mLVr73fp", amount,
                                                             fee, "", "", "certify",
                                                             new String[]{"tz1VsnrJhJgQvgbLWgAktfRScWNDGh6BmXdP", "Ray"}, false, Global.GENERIC_STANDARD);
      System.out.println(jsonObject.get("result"));*/

      /*BigDecimal amount = new BigDecimal("50");
      BigDecimal fee = new BigDecimal("0.00294"); 
      JSONObject jsonObject = wallet3.send("tz1UyUZgwgPmBG5DK5fKfdRxCjgVM4ELzYAS", "tz1LHBZeuAZRFZSDVzib6cJd3VF57DcpJKj2", amount, fee, "", ""); 
      System.out.println(jsonObject.get("result"));*/


      /*BigDecimal amount = new BigDecimal("0");
      BigDecimal fee = new BigDecimal("0.1");
      JSONObject jsonObject = wallet1.callContractEntryPoint(wallet1.getPublicKeyHash(), "KT1SXh2qT4xtDm4E7YHKdpWNav5Rj32fpyDC", amount,
                                                             fee, "", "", "replace",
                                                             new String[]{"1817"}, false, Global.GENERIC_STANDARD);*/
      /* 
      // Or... creates (imports) a new wallet with its keys. 
      TezosWallet wallet = new TezosWallet(privateKey, publicKey, publicKeyHash, myPassphrase);
       
       // Or... imports a previously owned wallet with mnemonic words and passphrase. 
       TezosWallet wallet = new TezosWallet("word1, word2, word3, ... word15 ", "myPassphrase");
       
       // Some environment configuration. 
       wallet.setIgnoreInvalidCertificates(false); 
       wallet.setProxy("", "");
       
       // Shows some wallet data output.
       System.out.println(wallet.getMnemonicWords());
       System.out.println(wallet.getPublicKeyHash());
       System.out.println(wallet.getBalance());
       
       // Saves the current wallet from memory to file.
       wallet.save("c:\\temp\\mySavedWallet.txt");
       
       System.out.println("Saved the wallet to disk.");
       
       // Creates a new wallet by reading from file. 
       TezosWallet myLoadedWallet = new TezosWallet(true, "c:\\temp\\mySavedWallet.txt", "myPassphrase");
       System.out.println("Loaded the wallet from disk:");
       
       // Shows loaded wallet data.
       System.out.println(myLoadedWallet.getMnemonicWords());
       System.out.println(myLoadedWallet.getPublicKeyHash());
       System.out.println(myLoadedWallet.getBalance());
       
       // Example of Sending funds.
       BigDecimal amount = new BigDecimal("0.123456");
       BigDecimal fee = new BigDecimal("0.00294"); 
       JSONObject jsonObject = wallet.send("tz1FromAddress", "tz1ToAddress", amount, fee, "", ""); 
       System.out.println(jsonObject.get("result"));
       
       // Using Conseil Gateway, from Cryptonomic. 
       ConseilGateway cg = new ConseilGateway(new URL("<URL>"), "<APIKEY>", "alphanet");
       
       // Example of origination operation.
       BigDecimal fee = new BigDecimal("0.001300");  // Needed fee for origination. 
       BigDecimal amount = new BigDecimal("2");      // Starting new kt1_delegator address balance. 
       JSONObject jsonObject = wallet.originate(wallet.getPublicKeyHash(), true, true, fee, "", "", amount, "", "");
       System.out.println(jsonObject.get("result"));
       
       // Example of delegation operation.
       BigDecimal fee = new BigDecimal("0.001300"); 
       JSONObject jsonObject = wallet.delegate("kt1_delegatorAddress", "tz1_delegate_address", fee, "", "");
       System.out.println(jsonObject.get("result"));
       
       // Example of undelegation operation. 
       BigDecimal fee = new BigDecimal("0.001300"); 
       JSONObject jsonObject = wallet.undelegate("kt1_delegatorAddress", fee);
       System.out.println(jsonObject.get("result"));
   
       
       // Tools
       
       // Routine to extract the publicKey from a privateKey. 
       String mySecretKey = "edsk...";
       String publicKey = Crypto.getPkFromSk(mySecretKey);
       System.out.println(publicKey);
       
       
       // Batch transactions.
       
       // Example of sending batch transactions.
       
       // Clears the transactions batch.
       wallet.clearTransactionBatch();
       
       // Adds a first transaction to the batch.
       wallet.addTransactionToBatch("from_address", "to_address", new BigDecimal("1"), new BigDecimal("0.00294"));
       
       // Adds a second transaction to the batch.
       wallet.addTransactionToBatch("from_address", "to_address", new BigDecimal("2"), new BigDecimal("0.00294"));
       
       // Adds a third transaction to the batch.
       wallet.addTransactionToBatch("from_address", "to_address", new BigDecimal("3"), new BigDecimal("0.00294"));
       // Note that "from_address" above maybe the manager address or its originated kt1 addresses.
       
       // Gets a list of wallet's current (pending) batch transactions.
       ArrayList<BatchTransactionItem> myBatchTransactionsList = new ArrayList<BatchTransactionItem>(); 
       myBatchTransactionsList = wallet.getTransactionList();
       
       // Sends all transactions in the batch to the blockchain and clears the batch. 
       JSONObject jsonObject = wallet.flushTransactionBatch();
       
       // Or... Specifying gasLimit and storageLimit: 
       JSONObject jsonObject = wallet.flushTransactionBatch("15400","300");
       System.out.println("Batch transaction sent! Returned operation hash is: ");
       System.out.println(jsonObject.get("result"));
               
       // Synchronously waits for previous operation to be included in a block after sending another one.
       // (this is to be used if you need to send a sequence of single transactions, having to wait first for each one to be included).        
       BigDecimal amount = new BigDecimal("0.02"); 
       BigDecimal fee = new BigDecimal("0.00294"); 
       JSONObject jsonObject = wallet.send("tz1FromAddress", "tz1ToAddress", amount, fee, "", ""); 
       String opHash = (String) jsonObject.get("result"); 
       Boolean opHashIncluded = wallet.waitForResult(opHash, numberOfBlocksToWait);
       System.out.println(opHashIncluded); 
       // Now it is safe to send another transaction at this point.


       /////////////////////////////////////////////////
       //                                             //
       // Smart Contract calls.                       //
       //                                             //
       /////////////////////////////////////////////////
       
       
       // Calls a smart contract in testnet.
       // Basically you need to provide the contract KT address, the name of the entrypoint you are calling
       // and a "new String[]" array with the parameters. 
       // IMPORTANT: Before calling the contract, check the name of the called entrypoint
       // and the order of your parameters.
       // You don't need to create the Micheline parameters.
       // TezosJ will create them for you on-the-fly. 
       // See an example:
       
       BigDecimal amount = new BigDecimal("0");
       BigDecimal fee = new BigDecimal("0.1"); 
       JSONObject jsonObject = wallet.callContractEntryPoint("TZ1_FromAddress", "KT1_SmartContractAddress", amount,
                                                             fee, gasLimit, storageLimit, entryPoint,
                                                             new String[]{"param_1", "param_2", "...", "param_n"}, false, Global.GENERIC_STANDARD);
    
                                                             
       ////////////////////////////////////////////////////////////////////////////////////////////////////////
       // Now a functional example (remember that your wallet must be funded and revealed for this to work). //
       ////////////////////////////////////////////////////////////////////////////////////////////////////////
               
               
       // Change wallet provider to use testnet.
       wallet.setProvider("https://testnet-tezos.giganode.io:443");
       
       // Sets amount and fee for the transaction. 
       BigDecimal amount = new BigDecimal("0");     // To call a contract, you send 0 tez.
       BigDecimal fee = new BigDecimal("0.1");      // Minimum fee to call contracts.
       System.out.println("Calling the contract (inserting customer 1, please wait a minute)...");
       
       // Calls the contract. 
       JSONObject jsonObject = wallet.callContractEntryPoint( wallet.getPublicKeyHash(), "KT18pK2MGrnTZqyTafUe1sWp2ubJ75eYT86t",
                                                              amount, fee, "", "", "addCustomer",
                                                              new String[]{"1000000", "001", "Bob", "98769985"}, false, Global.GENERIC_STANDARD);
       
       // Waits for the transaction to be included, so that we can call the contract once more.
       String opHash = (String) jsonObject.get("result"); 
       Boolean opHashIncluded = wallet.waitForResult(opHash, 8);
       System.out.println(opHashIncluded + " " + opHash);
       
       System.out.println("Calling the contract (insert customer 2, please wait a minute)...");
       
       // Calls the contract again. 
       jsonObject = wallet.callContractEntryPoint( wallet.getPublicKeyHash(),
                                                   "KT18pK2MGrnTZqyTafUe1sWp2ubJ75eYT86t", amount, fee,
                                                   "", "", "addCustomer", 
                                                   new String[]{"2000000", "002", "Alice", "97788657"}, false, Global.GENERIC_STANDARD);
       
       // Waits for the transaction to be included, so that we may call the contract once more. 
       opHash = (String) jsonObject.get("result"); 
       opHashIncluded = wallet.waitForResult(opHash, 8);
       System.out.println(opHashIncluded + " " + opHash);

     
       /////////////////////////////////////////////
       //      Calling FA1.2 Smart Contracts      //
       /////////////////////////////////////////////


      BigDecimal amount = new BigDecimal("0");
      BigDecimal fee = new BigDecimal("0.1");
      
        JSONObject jsonObject = wallet.FA12_getBalance("KT1_smartContractAddress", "TZ1_owner");
      //JSONObject jsonObject = wallet.FA12_getTotalSupply("KT1_smartContractAddress");
      //JSONObject jsonObject = wallet.FA12_transfer("KT1_smartContractAddress", "from_address", "to_address", new BigInteger("integer_value"));
      //JSONObject jsonObject = wallet.FA12_getAllowance("KT1_smartContractAddress", "owner_address", "spender_address");
      //JSONObject jsonObject = wallet.FA12_approve("KT1_smartContractAddress", "spender_address", new BigInteger("integer_value"));

      // Show result (transaction hash or error message).  
      System.out.println(jsonObject.get("result"));

     
     
     */
      
   }
}