public class DNSMessage {

    //This corresponds to an entire DNS Message.
    // the DNS Header
    // an array of questions
    // an array of answers
    // an array of "authority records" which we'll ignore
    // an array of "additional records" which we'll almost ignore

    static DNSMessage decodeMessage(byte[] bytes) {

    }

    //read the pieces of a domain name starting from the current position of the input stream
    String[] readDomainName(InputStream) {

    }

    //same, but used when there's compression and we need to find the domain from earlier in the message. 
    //This method should make a ByteArrayInputStream that starts at the specified byte and call the other version of this method
    String[] readDomainName(int firstByte) {

    }

    //build a response based on the request and the answers you intend to send back
    static DNSMessage buildResponse(DNSMessage request, DNSRecord[] answers) {

    }

    //get the bytes to put in a packet and send back
    byte[] toBytes() {

    }

    //If this is the first time we've seen this domain name in the packet, write it using the DNS encoding 
    //(each segment of the domain prefixed with its length, 0 at the end), and add it to the hash map. 
    //Otherwise, write a back pointer to where the domain has been seen previously.
    static void writeDomainName(ByteArrayOutputStream, HashMap<String,Integer> domainLocations, String[] domainPieces) {

    }

    //join the pieces of a domain name with dots ([ "utah", "edu"] -> "utah.edu" )
    String octetsToString(String[] octets) {

    }

    String toString() {
        
    }
    
}
