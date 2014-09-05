import com.eski.spanish.model.language.syllabifier.SyllabifiedWord;
import com.eski.spanish.model.language.syllabifier.Syllabifier;
import junit.framework.TestCase;

public class Tests extends TestCase {

    protected void setUp() {
        Syllabifier.setDividerSymbol("-");
    }

    private static final String[][] VCV_SOURCE_TARGET = {
            {"comunidad", "co-mu-ni-dad"},
            {"pelo", "pe-lo"},
            {"dedo", "de-do"},
            {"sonido", "so-ni-do"},
            {"chocolate", "cho-co-la-te"},
            {"muchacha", "mu-cha-cha"},
            {"calle", "ca-lle"},
            {"barra", "ba-rra"}
    };
    private static final String[][] VCCV_SOURCE_TARGET = {
            {"bloque", "blo-que"},
            {"habla", "ha-bla"},
            {"cruza", "cru-za"},
            {"sacrifica", "sa-cri-fi-ca"},
            {"fruta", "fru-ta"},
            {"refranes", "re-fra-nes"},
            {"placer", "pla-cer"},
            {"diploma", "di-plo-ma"},
            {"broma", "bro-ma"},
            {"pobre", "po-bre"},
            {"droga", "dro-ga"},
            {"ladrillo", "la-dri-llo"},
            {"glosa", "glo-sa"},
            {"regla", "re-gla"},
            {"prepara", "pre-pa-ra"},
            {"represa", "re-pre-sa"},
            {"claro", "cla-ro"},
            {"declive", "de-cli-ve"},
            {"florece", "flo-re-ce"},
            {"refleja", "re-fle-ja"},
            {"grosero", "gro-se-ro"},
            {"agradecido", "a-gra-de-ci-do"},
            {"trabajo", "tra-ba-jo"},
            {"patrocina", "pa-tro-ci-na"},

            {"abnegar", "ab-ne-gar"},
            {"directo", "di-rec-to"},
            {"pintura", "pin-tu-ra"},
            {"fútbol", "fút-bol"},
            {"obtener", "ob-te-ner"},
            {"admitir", "ad-mi-tir"},
            {"charlemos", "char-le-mos"},
            {"escolar", "es-co-lar"},
            {"acceso", "ac-ce-so"},
            {"indica", "in-di-ca"},
            {"persona", "per-so-na"},
            {"esfuma", "es-fu-ma"}
    };
    private final static String[][] VCCCV_SOURCE_TARGET = {
            {"asamblea", "a-sam-ble-a"},
            {"empresa", "em-pre-sa"},
            {"tendremos", "ten-dre-mos"},
            {"controla", "con-tro-la"},
            {"costumbre", "cos-tum-bre"},
            {"incluye", "in-clu-ye"},
            {"enfrenta", "en-fren-ta"},
            {"restringe", "res-trin-ge"},
            {"simplemente", "sim-ple-men-te"},
            {"transcurre", "trans-cu-rre"},
            {"consciente", "cons-cien-te"},
            {"perspectiva", "pers-pec-ti-va"},
            {"extinguir", "ex-tin-guir"},
            {"inspira", "ins-pi-ra"},
            {"constituye", "cons-ti-tu-ye"},
            {"exponer", "ex-po-ner"},
            {"excluye", "ex-clu-ye"},
            {"extreme", "ex-tre-me"}
    };
    
    private final static String[][] VCCCCV_SOURCE_TARGET = {
            {"inscribe", "ins-cri-be"},
            {"construye", "cons-tru-ye"},
            {"excluye", "ex-clu-ye"},
            {"extremo", "ex-tre-mo"},
            {"transplantar", "trans-plan-tar"},
            {"abstracto", "abs-trac-to"},
            {"expresa", "ex-pre-sa"}
    };
    private final static String[][] VV_SOURCE_TARGET = {
            {"atraer", "a-tra-er"},
            {"costear", "cos-te-ar"},
            {"policía", "po-li-cí-a"},
            {"oasis", "o-a-sis"},
            {"fluctúa", "fluc-tú-a"},
            {"país", "pa-ís"},
            {"proteína", "pro-te-í-na"},
            {"enfríe", "en-frí-e"},
            {"suroeste", "su-ro-es-te"},
            {"continúe", "con-ti-nú-e"},
            {"extraoficial", "ex-tra-o-fi-cial"},
            {"correo", "co-rre-o"},
            {"heroína", "he-ro-í-na"},
            {"oído", "o-í-do"},
            {"Raúl", "Ra-úl"},
            {"farmaceútico", "far-ma-ce-ú-ti-co"},

            {"paisaje", "pai-sa-je"},
            {"peinado", "pei-na-do"},
            {"familiares", "fa-mi-lia-res"},
            {"oigo", "oi-go"},
            {"actualmente", "ac-tual-men-te"},
            {"aumento", "au-men-to"},
            {"neutro", "neu-tro"},
            {"pariente", "pa-rien-te"},
            {"estadounidense", "es-ta-dou-ni-den-se"},
            {"encuentra", "en-cuen-tra"},
            {"nacional", "na-cio-nal"},
            {"gratuito", "gra-tui-to"},
            {"ciudadano", "ciu-da-da-no"}
    };

    public void testVCV() {
        for (String[] sourceTarget : VCV_SOURCE_TARGET) {
            assertEquals(sourceTarget[1], new SyllabifiedWord(sourceTarget[0]).toString());
        }
    }
    public void testVCCV() {
        for (String[] sourceTarget : VCCV_SOURCE_TARGET) {
            assertEquals(sourceTarget[1], new SyllabifiedWord(sourceTarget[0]).toString());
        }
    }
    public void testVCCCV() {
        for (String[] sourceTarget : VCCCV_SOURCE_TARGET) {
            assertEquals(sourceTarget[1], new SyllabifiedWord(sourceTarget[0]).toString());
        }
    }
    public void testVCCCCV() {
        for (String[] sourceTarget : VCCCCV_SOURCE_TARGET) {
            assertEquals(sourceTarget[1], new SyllabifiedWord(sourceTarget[0]).toString());
        }
    }
    public void testVV() {
        for (String[] sourceTarget : VV_SOURCE_TARGET) {
            assertEquals(sourceTarget[1], new SyllabifiedWord(sourceTarget[0]).toString());
        }
    }
}
