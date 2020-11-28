import java.io.*;
import java.util.*;
import javafx.scene.*;
import javafx.application.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.Pos;

public class Notes extends Application {

	//GUI elements creation starts here.

    private static final double WIDTH = 960.0;
    private static final double HEIGHT = 960.0;
    
    //col1's elements
    private static final Text lnamel = new Text("Last name:");
    private static final Text fnamel = new Text("\nFirst name:");
    private static final Text dobl = new Text("\nDate of Birth: (MM/DD/YYYY)");
    private static final Text sexl = new Text("\nGender:");
    private static final Text elecstiml = new Text("\nElectrical Stimulation:");
    private static final Text doctl = new Text("\nDoctor:");
    private static final TextField lname = new TextField();
    private static final TextField dob = new TextField();
    private static final ChoiceBox<String> elecstim = new ChoiceBox<String>();
    private static final ChoiceBox<String> sex = new ChoiceBox<String>();
    private static final ChoiceBox<String> doct = new ChoiceBox<String>();
    private static final TextField fname = new TextField();
    private static final Button makeit = new Button("SAVE/Create Notes");
    private static final Button cleardates = new Button("CLEAR dates/diag");
    private static final Button clearall = new Button("CLEAR patient");
    private static final Button clearstates = new Button("CLEAR states");
    private static final Button clearcons = new Button("CLEAR conditions");

    //col2's elements
    private static final Text ptstatesl = new Text("Pt. States:");
    private static final CheckBox hab = new CheckBox();
    private static final Text hap = new Text("Headache scale about ");
	private static final TextField has = new TextField();
    private static final CheckBox hadb = new CheckBox();
    private static final Text had = new Text("Dizziness");
    private static final CheckBox hatb = new CheckBox();
    private static final Text hat = new Text("Tension");
    private static final Text hafor = new Text("for ");
    private static final ChoiceBox<String> haforcb = new ChoiceBox<String>();
	private static final TextField hafort = new TextField();
    private static final CheckBox nb = new CheckBox();
    private static final CheckBox npb = new CheckBox();
    private static final Text np = new Text("Neck       pain, scale about ");
	private static final TextField nps = new TextField();
    private static final CheckBox nstiffb = new CheckBox();
    private static final Text nstiff = new Text("Stiffness");
    private static final Text nfor = new Text("for ");
    private static final ChoiceBox<String> nforcb = new ChoiceBox<String>();
	private static final TextField nfort = new TextField();
    private static final CheckBox bb = new CheckBox();
    private static final CheckBox bpb = new CheckBox();
    private static final Text bp = new Text("Back       pain, scale about ");
	private static final TextField bps = new TextField();
    private static final CheckBox bmsb = new CheckBox();
    private static final Text bms = new Text("Muscle Spasm");
    private static final CheckBox btb = new CheckBox();
    private static final Text bt = new Text("Tension");
    private static final CheckBox bsiderb = new CheckBox();
    private static final CheckBox bsidelb = new CheckBox();
    private static final Text bside = new Text("on       right       left side");
    private static final Text bfor = new Text("for ");
    private static final ChoiceBox<String> bforcb = new ChoiceBox<String>();
	private static final TextField bfort = new TextField();
    private static final CheckBox lbb = new CheckBox();
    private static final CheckBox lbpb = new CheckBox();
    private static final Text lbp = new Text("Lower back       pain, scale about ");
	private static final TextField lbps = new TextField();
    private static final CheckBox lbmb = new CheckBox();
    private static final Text lbm = new Text("Muscle Spasm");
    private static final CheckBox lbtb = new CheckBox();
    private static final Text lbt = new Text("Tension");
    private static final CheckBox lbsiderb = new CheckBox();
    private static final CheckBox lbsidelb = new CheckBox();
    private static final Text lbside = new Text("on       right       left side");
    private static final Text lbfor = new Text("for ");
    private static final ChoiceBox<String> lbforcb = new ChoiceBox<String>();
	private static final TextField lbfort = new TextField();
	//diagnosis section elements
	private static final Text diagnosisl = new Text("Diagnosis:");
    private static final Text headl = new Text("Head G24.89 G44.5 R51");
    private static final CheckBox head = new CheckBox();
    private static final Text neckl = new Text("Neck M54.2");
    private static final CheckBox neck = new CheckBox();
    private static final Text mbackl = new Text("Middle Back M54.6");
    private static final CheckBox mback = new CheckBox();
    private static final Text lbackl = new Text("Lower Back M54.5");
    private static final CheckBox lback = new CheckBox();
    private static final Text sciatical = new Text("    Sciatica M54.31");
    private static final CheckBox sciatica = new CheckBox();
    private static final CheckBox sciaticar = new CheckBox();
    private static final Text shoulderl = new Text("   Shoulder M25.511");
    private static final CheckBox shoulder = new CheckBox();
    private static final CheckBox shoulderr = new CheckBox();
    private static final Text uarml = new Text("Upper Arm M79.601");
    private static final CheckBox uarm = new CheckBox();
    private static final CheckBox uarmr = new CheckBox();
    private static final Text elbowl = new Text("    Elbow M25.521");
    private static final CheckBox elbow = new CheckBox();
    private static final CheckBox elbowr = new CheckBox();
    private static final Text farml = new Text("   Forearm M79.631");
    private static final CheckBox farm = new CheckBox();
    private static final CheckBox farmr = new CheckBox();
    private static final Text wristl = new Text("     Wrist M25.531");
    private static final CheckBox wrist = new CheckBox();
    private static final CheckBox wristr = new CheckBox();
    private static final Text handl = new Text("     Hand M25.541");
    private static final CheckBox hand = new CheckBox();
    private static final CheckBox handr = new CheckBox();
    private static final Text pelvisl = new Text("        Hip M25.551");
    private static final CheckBox pelvis = new CheckBox();
    private static final CheckBox pelvisr = new CheckBox();
    private static final Text thighl = new Text("     Thigh M79.651");
    private static final CheckBox thigh = new CheckBox();
    private static final CheckBox thighr = new CheckBox();
    private static final Text legl = new Text("      Leg M79.661");
    private static final CheckBox leg = new CheckBox();
    private static final CheckBox legr = new CheckBox();
    private static final Text kneel = new Text("     Knee M25.561");
    private static final CheckBox knee = new CheckBox();
    private static final CheckBox kneer = new CheckBox();
    private static final Text footl = new Text("     Foot M25.571");
    private static final CheckBox foot = new CheckBox();
    private static final CheckBox footr = new CheckBox();
    private static final Text ll = new Text("Left 2");
    private static final Text rl = new Text("Right 1");
    private static final TextField numtreat = new TextField();
    private static final Text numtreatl = new Text("Number of Treatments");

    //col3's elements, mainly the dateslist
    private static final Text datesl = new Text("\nDates (MM/DD/YY)\nPress Enter to\n-check if date is correct\n-add prompt for another date\n-remove unneeded date");

    //col4's elements
    private static final Text patcondl = new Text("Patient Condition:");
	private static final ChoiceBox<String> patcond = new ChoiceBox<String>();
    private static final Text patactl = new Text("Patient Activity:");
    private static final TextArea patact = new TextArea();
    private static final Text anychangel = new Text("Since last treatment, patient's condition has:");
	private static final ChoiceBox<String> anychange = new ChoiceBox<String>();
	private static final Text addinjl = new Text("Any additional injuries gained?");
    private static final TextArea addinj = new TextArea();
    private static final Text addpainl = new Text("Any additional pains, discomforts?");
    private static final TextArea addpain = new TextArea();
    private static final Text pulsel = new Text("Patient's pulse:");
	private static final ChoiceBox<String> pulse = new ChoiceBox<String>();
	private static final Text tonguel = new Text("Patient's tongue:");
    private static final ChoiceBox<String> tongue = new ChoiceBox<String>();
    private static final Text addnotesl = new Text("Additional notes:");
    private static final TextArea addnotes = new TextArea();
	private static final Text arrivesl = new Text("Pt comes to the office");
	private static final ChoiceBox<String> arrives = new ChoiceBox<String>();
	private static final Text followl = new Text("Treatment followed by:");
	private static final CheckBox cupb = new CheckBox();
	private static final CheckBox presb = new CheckBox();
	private static final CheckBox hotb = new CheckBox();
	private static final CheckBox infb = new CheckBox();
	private static final Text responsel = new Text("Pt response to treatment:");
	private static final CheckBox wellb = new CheckBox();
	private static final CheckBox psrb = new CheckBox();
	private static final TextField pss = new TextField();
	private static final CheckBox tirb = new CheckBox();
	private static final CheckBox mrb = new CheckBox();
	private static final CheckBox fbb = new CheckBox();
	private static final CheckBox srb = new CheckBox();
	private static final CheckBox terb = new CheckBox();
	private static final CheckBox wbb = new CheckBox();
	private static final CheckBox bib = new CheckBox();
	private static final CheckBox ncb = new CheckBox();
	private static final Text planl = new Text("Plan:");
	private static final CheckBox conb = new CheckBox();
	private static final CheckBox homb = new CheckBox();
	private static final CheckBox herb = new CheckBox();
	private static final CheckBox othb = new CheckBox();
	private static final Text cupl = new Text("cupping");
	private static final Text presl = new Text("acupressure");
	private static final Text hotl = new Text("hot pack");
	private static final Text infl = new Text("infrared");
	private static final Text welll = new Text("well");
	private static final Text psrl = new Text("pain scale reduced to");
	private static final Text tirl = new Text("tingling reduced");
	private static final Text mrl = new Text("muscles relaxed");
	private static final Text fbl = new Text("feeling better");
	private static final Text srl = new Text("stiffness reduced");
	private static final Text terl = new Text("tension released");
	private static final Text wbl = new Text("walking better");
	private static final Text bil = new Text("balance improved");
	private static final Text ncl = new Text("no change");
	private static final Text conl = new Text("Continue treatment plan");
	private static final Text homl = new Text("Home self care provided");
	private static final Text herl = new Text("Pt is advised to take herbal medicine");
	private static final Text othl = new Text("Pt is advised to see other doctors");

	//GUI element creation stops here.


	//Program is run from main: GUI setup.

    public static void main(String[] args) {
        launch(args);
    }

    //Error Message setup, GUI Elements setup

    @Override
    public void start(Stage stage) {
		Text warning = new Text("You've entered a date incorrectly");
		warning.setTranslateX(30);
		warning.setTranslateY(400);
		Text Success = new Text("Files have been created");
		Success.setTranslateX(30);
		Success.setTranslateY(415);
		VBox successpane = new VBox();
		successpane.getChildren().addAll(Success);
		ArrayList<TextField> datelist = new ArrayList<TextField>(0);
		datelist.add(new TextField());
		datelist.get(0).setMaxWidth(175);
		lname.setMaxWidth(175);
		dob.setMaxWidth(175);
		fname.setMaxWidth(175);
		has.setMaxWidth(30);
		hafort.setMaxWidth(30);
		nps.setMaxWidth(30);
		nfort.setMaxWidth(30);
		bps.setMaxWidth(30);
		bfort.setMaxWidth(30);
		lbps.setMaxWidth(30);
		lbfort.setMaxWidth(30);
		pss.setMaxWidth(30);
		numtreat.setMaxWidth(30);

		sex.getItems().addAll("Female", "Male");
		elecstim.getItems().addAll("with", "without");
		doct.getItems().addAll("None");
		doct.getSelectionModel().selectFirst();
		patcond.getItems().addAll("Normal", "Drowsy", "Insomnia", "Fatigued", "Energetic", "Refer to Additional notes");
		anychange.getItems().addAll("improved", "not changed", "worsened");
		pulse.getItems().addAll("Normal", "Slow", "Fast", "Abnormal/Irregular", "Refer to Additional notes");
		tongue.getItems().addAll("Normal", "White", "Lumpy", "Dry", "Refer to Additional notes");
		haforcb.getItems().addAll("days", "weeks", "months", "years");
		nforcb.getItems().addAll("days", "weeks", "months", "years");
		bforcb.getItems().addAll("days", "weeks", "months", "years");
		lbforcb.getItems().addAll("days", "weeks", "months", "years");
		arrives.getItems().addAll("unspecified", "Walking by self", "Walking with cane", "Walking with walker", "Via Wheelchair");

		patact.setMaxWidth(275);
		patact.setPrefRowCount(3);
		patact.setWrapText(true);
		addinj.setMaxWidth(275);
		addinj.setPrefRowCount(3);
		addinj.setWrapText(true);
		addpain.setMaxWidth(275);
		addpain.setPrefRowCount(3);
		addpain.setWrapText(true);
		addnotes.setMaxWidth(275);
		addnotes.setPrefRowCount(3);
		addnotes.setWrapText(true);

		//default first option for selection elements (unnecessary)
		/* 
		elecstim.getSelectionModel().selectFirst();
		patcond.getSelectionModel().selectFirst();
		anychange.getSelectionModel().selectFirst();
		pulse.getSelectionModel().selectFirst();
		tongue.getSelectionModel().selectFirst();
		haforcb.getSelectionModel().selectFirst();
		nforcb.getSelectionModel().selectFirst();
		bforcb.getSelectionModel().selectFirst();
		lbforcb.getSelectionModel().selectFirst();
		arrives.getSelectionModel().selectFirst();
		*/


		//Gui Creation, addition of GUI elements

		stage.setTitle("Acupuncture Notes");
		Group root = new Group();
		Pane gui = new Pane();
		Pane col1 = new Pane();
		col1.getChildren().addAll(
			lnamel,
			lname,
			fnamel,
			fname,
			dobl,
			dob,
			elecstiml,
			elecstim,
			sexl,
			sex,
			doctl,
			doct,
			clearstates,
			cleardates,
			clearcons,
			makeit,
			clearall);
		Pane col2 = new Pane();
		Pane hadiag = new Pane();
		hadiag.getChildren().addAll(
			ptstatesl,
		    hap,
		    had,
		    hat,
		    hafor,
		    hab,
			has,
		    hadb,
		    hatb,
			hafort,
			haforcb);
		Pane ndiag = new Pane();
		ndiag.getChildren().addAll(
		    np,
		    nstiff,
		    nfor,
			nb,
		    npb,
			nps,
		    nstiffb,
			nfort,
			nforcb);
		Pane bdiag = new Pane();
		bdiag.getChildren().addAll(
		    bp,
		    bms,
		    bt,
		    bside,
		    bfor,
			bb,
		    bpb,
			bps,
		    bmsb,
		    btb,
		    bsiderb,
		    bsidelb,
			bfort,
			bforcb);
		Pane lbdiag = new Pane();
		lbdiag.getChildren().addAll(
		    lbp,
		    lbm,
		    lbt,
		    lbside,
		    lbfor,
			lbb,
		    lbpb,
			lbps,
		    lbmb,
		    lbtb,
		    lbsiderb, 
		    lbsidelb,
			lbfort,
			lbforcb);
		Pane generaldiag = new Pane();
		generaldiag.getChildren().addAll(
			headl,
			head,
			neckl,
			neck,
			mbackl,
			mback,
			lbackl,
			lback);
		Pane leftdiag = new Pane();
		leftdiag.getChildren().addAll(
			//sciatica,
			shoulder,
			uarm,
			elbow,
			farm,
			wrist,
			hand,
			pelvis,
			thigh,
			leg,
			knee,
			foot);
		Pane labeldiag = new Pane(
			//sciatical,
			shoulderl,
			uarml,
			elbowl,
			farml,
			wristl,
			handl,
			pelvisl,
			thighl,
			legl,
			kneel,
			footl);
		Pane rightdiag = new Pane();
		rightdiag.getChildren().addAll(
			//sciaticar,
			shoulderr,
			uarmr,
			elbowr,
			farmr,
			wristr,
			handr,
			pelvisr,
			thighr,
			legr,
			kneer,
			footr);
		col2.getChildren().addAll(
			hadiag,
			ndiag,
			bdiag,
			lbdiag,
			generaldiag,
			ll,
			rl,
			leftdiag,
			labeldiag,
			rightdiag,
			numtreatl,
			numtreat);
		
		Pane col3 = new Pane();
		col3.getChildren().addAll(datesl);
		for (int i = 0; i < datelist.size(); i++){
		    col3.getChildren().addAll(datelist.get(i));
		    datelist.get(i).setTranslateY(90 + (25 * i));
		}

		Pane col4 = new Pane();
		col4.getChildren().addAll(
				    patcondl,
					patcond,
		    		patactl,
		    		patact,
		    		anychangel,
					anychange,
					addinjl,
		    		addinj,
		    		addpainl,
		    		addpain,
		    		pulsel,
					pulse,
					tonguel,
		    		tongue,
		  		  	addnotesl,
				    addnotes,
				    arrivesl,
					arrives,
					followl,
					cupb,
					presb,
					hotb,
					infb,
					responsel,
					wellb,
					psrb,
					pss,
					tirb,
					mrb,
					fbb,
					srb,
					terb,
					wbb,
					bib,
					ncb,
					planl,
					conb,
					homb,
					herb,
					othb,
					cupl,
					presl,
					hotl,
					infl,
					welll,
					psrl,
					tirl,
					mrl,
					fbl,
					srl,
					terl,
					wbl,
					bil,
					ncl,
					conl,
					homl,
					herl,
					othl);

		gui.getChildren().addAll(col1, col2, col3, col4);

		//col1's translates
		col1.setTranslateX(30);
		lnamel.setTranslateY(25);
		lname.setTranslateY(30);
		fnamel.setTranslateY(55);
		fname.setTranslateY(75);
		dobl.setTranslateY(100);
		dob.setTranslateY(120);
		elecstiml.setTranslateY(145);
		elecstim.setTranslateY(165);
		sexl.setTranslateY(190);
		sex.setTranslateY(210);
		doctl.setTranslateY(235);
		doct.setTranslateY(255);
		clearstates.setTranslateY(529);
		cleardates.setTranslateY(579);
		clearcons.setTranslateY(629);
		makeit.setTranslateY(679);
		clearall.setTranslateY(729);

		//col2's translates
		col2.setTranslateX(215);

			//hadiag
		hadiag.setTranslateY(25);
	    hab.setTranslateY(7);
	    hap.setTranslateY(21);
	    hap.setTranslateX(20);
		has.setTranslateY(4);
		has.setTranslateX(150);
	    hadb.setTranslateY(32);
		hadb.setTranslateX(50);
	    had.setTranslateY(46);
	    had.setTranslateX(70);
	    hatb.setTranslateY(32);
	    hatb.setTranslateX(130);
	    hat.setTranslateY(46);
	    hat.setTranslateX(150);
	    hafor.setTranslateY(21);
	    hafor.setTranslateX(246);
		hafort.setTranslateY(4);
	    hafort.setTranslateX(265);
		haforcb.setTranslateY(4);
	    haforcb.setTranslateX(300);
	    	//ndiag
	    ndiag.setTranslateY(80);
	    npb.setTranslateX(50);
	    np.setTranslateX(20);
		nps.setTranslateX(165);
	    nstiffb.setTranslateX(50);
	    nstiff.setTranslateX(70);
	    nfor.setTranslateX(246);
		nfort.setTranslateX(265);
		nforcb.setTranslateX(300);
		nb.setTranslateY(7);
		npb.setTranslateY(7);
	    np.setTranslateY(21);
		nps.setTranslateY(4);
	    nstiffb.setTranslateY(32);
	    nstiff.setTranslateY(46);
	    nfor.setTranslateY(21);
		nfort.setTranslateY(4);
		nforcb.setTranslateY(4);
			//bdiag
		bdiag.setTranslateY(130);
	    bpb.setTranslateX(50);
	    bp.setTranslateX(21);
		bps.setTranslateX(163);
	    btb.setTranslateX(50);
	    bt.setTranslateX(70);
	    bmsb.setTranslateX(130);
	    bms.setTranslateX(150);
	    bsiderb.setTranslateX(68);
	    bsidelb.setTranslateX(115);
	    bside.setTranslateX(50);
	    bfor.setTranslateX(246);
		bfort.setTranslateX(265);
		bforcb.setTranslateX(300);
		bb.setTranslateY(12);
	    bpb.setTranslateY(12);
	    bp.setTranslateY(26);
		bps.setTranslateY(9);
	    btb.setTranslateY(37);
	    bt.setTranslateY(51);
	    bmsb.setTranslateY(37);
	    bms.setTranslateY(51);
	    bsiderb.setTranslateY(62);
	    bsidelb.setTranslateY(62);
	    bside.setTranslateY(76);
	    bfor.setTranslateY(26);
		bfort.setTranslateY(9);
		bforcb.setTranslateY(9);
			//bdiag
		lbdiag.setTranslateY(213);
	    lbpb.setTranslateX(83);
	    lbp.setTranslateX(20);
		lbps.setTranslateX(195);
	    lbtb.setTranslateX(50);
	    lbt.setTranslateX(70);
	    lbmb.setTranslateX(130);
	    lbm.setTranslateX(150);
	    lbsiderb.setTranslateX(68);
	    lbsidelb.setTranslateX(115);
	    lbside.setTranslateX(50);
	    lbfor.setTranslateX(246);
		lbfort.setTranslateX(265);
		lbforcb.setTranslateX(300);
	    lbb.setTranslateY(4);
	    lbpb.setTranslateY(4);
	    lbp.setTranslateY(18);
		lbps.setTranslateY(1);
	    lbtb.setTranslateY(29);
	    lbt.setTranslateY(43);
	    lbmb.setTranslateY(29);
	    lbm.setTranslateY(43);
	    lbsiderb.setTranslateY(54);
	    lbsidelb.setTranslateY(54);
	    lbside.setTranslateY(68);
	    lbfor.setTranslateY(18);
		lbfort.setTranslateY(1);
		lbforcb.setTranslateY(1);

		generaldiag.setTranslateY(305);
		int allin = 0;
		for (Node child:generaldiag.getChildren()){
			child.setTranslateX(((allin + 1) % 2) * 27);
			child.setTranslateY((allin / 2) * 27);
			if (allin % 2 == 0)  {
				child.setTranslateY(child.getTranslateY() + 14);}
			allin += 1;}
		ll.setTranslateY(430);
		rl.setTranslateY(430);
		rl.setTranslateX(140);
		leftdiag.setTranslateY(440);
		labeldiag.setTranslateY(440);
		labeldiag.setTranslateX(33);
		rightdiag.setTranslateY(440);
		rightdiag.setTranslateX(157);
		allin = 0;
		for (Node child:leftdiag.getChildren()){
			child.setTranslateY(allin * 27);
			allin += 1;}
			allin = 0;
		allin = 0;
		for (Node child:labeldiag.getChildren()){
			child.setTranslateY((allin * 27) + 14);
			allin += 1;}
		allin = 0;
		for (Node child:rightdiag.getChildren()){
			child.setTranslateY(allin * 27);
			allin += 1;}
		numtreatl.setTranslateY(785);
		numtreat.setTranslateY(768);
		numtreat.setTranslateX(145);

		//col3's basic translate
		col3.setTranslateX(440);
		col3.setTranslateY(300);

		//col4's translates
		col4.setTranslateX(640);
	    patcondl.setTranslateY(25);
		patcond.setTranslateY(30);
		patactl.setTranslateY(75);
		patact.setTranslateY(80);
		anychangel.setTranslateY(165);
		anychange.setTranslateY(170);
		addinjl.setTranslateY(210);
		addinj.setTranslateY(215);
		addpainl.setTranslateY(300);
		addpain.setTranslateY(305);
		pulsel.setTranslateY(390);
		pulse.setTranslateY(395);
		tonguel.setTranslateY(435);
		tongue.setTranslateY(440);
	  	addnotesl.setTranslateY(480);
	    addnotes.setTranslateY(485);
	    arrivesl.setTranslateY(570);
		arrives.setTranslateY(575);
		followl.setTranslateY(620);
		cupb.setTranslateY(607);
		cupb.setTranslateX(130);
		cupl.setTranslateY(620);
		cupl.setTranslateX(150);
		presb.setTranslateY(607);
		presb.setTranslateX(210);
		presl.setTranslateY(620);
		presl.setTranslateX(230);
		hotb.setTranslateY(627);
		hotb.setTranslateX(130);
		hotl.setTranslateY(640);
		hotl.setTranslateX(150);
		infb.setTranslateY(627);
		infb.setTranslateX(210);
		infl.setTranslateY(640);
		infl.setTranslateX(230);
		responsel.setTranslateY(660);
		wellb.setTranslateY(647);
		wellb.setTranslateX(140);
		welll.setTranslateY(660);
		welll.setTranslateX(160);
		psrb.setTranslateY(672);
		pss.setTranslateY(667);
		pss.setTranslateX(137);
		psrl.setTranslateY(685);
		psrl.setTranslateX(20);
		tirb.setTranslateY(697);
		tirl.setTranslateY(710);
		tirl.setTranslateX(20);
		mrb.setTranslateY(697);
		mrb.setTranslateX(160);
		mrl.setTranslateY(710);
		mrl.setTranslateX(180);
		fbb.setTranslateY(722);
		fbl.setTranslateY(735);
		fbl.setTranslateX(20);
		srb.setTranslateY(722);
		srb.setTranslateX(160);
		srl.setTranslateY(735);
		srl.setTranslateX(180);
		terb.setTranslateY(747);
		terl.setTranslateY(760);
		terl.setTranslateX(20);
		wbb.setTranslateY(747);
		wbb.setTranslateX(160);
		wbl.setTranslateY(760);
		wbl.setTranslateX(180);
		bib.setTranslateY(772);
		bil.setTranslateY(785);
		bil.setTranslateX(20);
		ncb.setTranslateY(772);
		ncb.setTranslateX(160);
		ncl.setTranslateY(785);
		ncl.setTranslateX(180);
		planl.setTranslateY(810);
		conb.setTranslateY(817);
		conl.setTranslateY(830);
		conl.setTranslateX(20);
		homb.setTranslateY(842);
		homl.setTranslateY(855);
		homl.setTranslateX(20);
		herb.setTranslateY(867);
		herl.setTranslateY(880);
		herl.setTranslateX(20);
		othb.setTranslateY(892);
		othl.setTranslateY(905);
		othl.setTranslateX(20);


	    BorderPane lborderpane = new BorderPane(gui);
	    root.getChildren().addAll(lborderpane);
	    Scene scene = new Scene(root, WIDTH, HEIGHT);
	    

		//Final line, show scene (GUI) now
	    stage.setScene(scene);
	    stage.setX(0);
	    stage.setY(0);
	    stage.show();
	}


}
