//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.23 at 01:41:44 AM CET 
//

package de.minecrawler.IR1.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"date", "mknote", "topics", "places", "people", "orgs", "exchanges", "companies", "unknown", "text"})
@XmlRootElement(name = "REUTERS")
public class XMLDocument {

    @XmlElement(name = "DATE", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDateTime date;

    @XmlElement(name = "MKNOTE")
    private String mknote;

    @XmlElement(name = "TOPICS", required = true)
    private DList topics;

    @XmlElement(name = "PLACES", required = true)
    private DList places;

    @XmlElement(name = "PEOPLE", required = true)
    private DList people;

    @XmlElement(name = "ORGS", required = true)
    private DList orgs;

    @XmlElement(name = "EXCHANGES", required = true)
    private DList exchanges;

    @XmlElement(name = "COMPANIES", required = true)
    private DList companies;

    @XmlElement(name = "UNKNOWN", required = true)
    private String unknown;

    @XmlElement(name = "TEXT", required = true)
    private XMLText text;

    @XmlAttribute(name = "CGISPLIT", required = true)
    private String cgisplit;

    @XmlAttribute(name = "CSECS")
    private BigInteger csecs;

    @XmlAttribute(name = "LEWISSPLIT", required = true)
    private String lewissplit;

    @XmlAttribute(name = "NEWID", required = true)
    private BigInteger newid;

    @XmlAttribute(name = "OLDID", required = true)
    private BigInteger oldid;

    @XmlAttribute(name = "TOPICS", required = true)
    @XmlJavaTypeAdapter(HasTopicsAdapter.class)
    private Boolean hastopics;

    protected XMLDocument() {
    }

    /**
     * @return The date of the document without any timezone!
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @return Some notes of someone about the documents (for example changes)
     */
    public String getMknote() {
        return mknote;
    }

    /**
     * @return Has the document topics? If this is false, {@link #getTopics()}
     *         will return an empty list
     */
    public Boolean hasTopics() {
        return hastopics;
    }

    /**
     * @return A copy list of the topics of this document
     */
    public List<String> getTopics() {
        return new ArrayList<String>(topics.getValue());
    }

    /**
     * @return A copy list of the places of this document
     */
    public List<String> getPlaces() {
        return new ArrayList<String>(places.getValue());
    }

    /**
     * @return A copy list of the places of the people (not the author!) of this
     *         document
     */
    public List<String> getPeople() {
        return new ArrayList<String>(people.getValue());
    }

    /**
     * @return A copy list of the organisations of this document
     */
    public List<String> getOrganisations() {
        return new ArrayList<String>(orgs.getValue());
    }

    /**
     * @return A copy list of the exchanges of this document
     */
    public List<String> getExchanges() {
        return new ArrayList<String>(exchanges.getValue());
    }

    /**
     * @return A copy list of the companies of this document
     */
    public List<String> getCompanies() {
        return new ArrayList<String>(companies.getValue());
    }

    /**
     * @return Uncategorized information about this document
     */
    public String getUnknown() {
        return unknown;
    }

    /**
     * @return The text body of the document
     */
    public XMLText getText() {
        return text;
    }

    // TODO: What is this?
    /**
     * @return Some information about the document?
     */
    public String getLewissplit() {
        return lewissplit;
    }

    // TODO: What is this?
    /**
     * @return Some information about the document?
     */
    public String getCgisplit() {
        return cgisplit;
    }

    // TODO: What is this?
    /**
     * @return Some information about the document?
     */
    public BigInteger getCsecs() {
        return csecs;
    }

    /**
     * @return An auto incrementing id of the document
     */
    public BigInteger getNewid() {
        return newid;
    }

    /**
     * @return The original id of the document
     */
    public BigInteger getOldid() {
        return oldid;
    }

    // Helper class to convert the date string to a Date object
    private static class DateAdapter extends XmlAdapter<String, LocalDateTime> {

        private static DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("dd-MMM-yyyy HH:mm:ss.SS");

        @Override
        public String marshal(LocalDateTime v) throws Exception {
            return DATE_FORMAT.print(v);
        }

        @Override
        public LocalDateTime unmarshal(String v) throws Exception {
            return DATE_FORMAT.parseLocalDateTime(v);
        }
    }

    // Helper class to convert YES/NO to boolean
    private static class HasTopicsAdapter extends XmlAdapter<String, Boolean> {

        @Override
        public String marshal(Boolean v) throws Exception {
            return v ? "YES" : "NO";
        }

        @Override
        public Boolean unmarshal(String s) throws Exception {
            return s.equals("YES");
        }
    }

    // Helper class to convert the values separated by D's to a String list
    private static class DList {

        @XmlElement(name = "D")
        private List<String> value = new ArrayList<String>();

        public List<String> getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

}
