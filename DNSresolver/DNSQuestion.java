public class DNSQuestion {

    //This class represents a client request.

    //read a question from the input stream. 
    //Due to compression, you may have to ask the DNSMessage containing this question to read some of the fields.
    static DNSQuestion decodeQuestion( InputStream, DNSMessage) {

    }
    
    //Write the question bytes which will be sent to the client. 
    //The hash map is used for us to compress the message, see the DNSMessage class below.
    void writeBytes( ByteArrayOutputStream, HashMap<String, Integer> domainNameLocations) {

    }


    // toString(), equals(), and hashCode() -- 
    // Let your IDE generate these. They're needed to use a question as a HashMap key, 
    // and to get a human readable string.
}

