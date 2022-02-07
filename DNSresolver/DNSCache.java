public class DNSCache {

    //This class is the local cache.

    HashMap<DNSQuestion, DNSRecord>


    // You can just store the first answer for any question in the cache (a response for google.com might return 10 IP addresses,
    // just store the first one).This class should have methods for querying and inserting records into the cache.
    // When you look up an entry, if it is too old (its TTL has expired), remove it and return "not found."
    
}
