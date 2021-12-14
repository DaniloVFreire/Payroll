package Models.syndicates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Syndicate implements Serializable {
    private UUID SyndicateId;
    private double tax;
    private ArrayList<AdditionalTax> additionalTaxes ;

}
