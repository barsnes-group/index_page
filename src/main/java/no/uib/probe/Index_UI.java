package no.uib.probe;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("no.uib.probe.Index_UI_Widgetset")
public class Index_UI extends UI {
    /**
     * Entry point - This is the initial Vaadin request method initialize
     * components and non-component functionality.
     *
     * @param vaadinRequest Main request object.
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
       setSizeFull();
        AbsoluteLayout container=new AbsoluteLayout();
        this.setContent(container);
        container.setSizeFull();
       Image probeLogo = new Image();
       probeLogo.setHeight(117,Unit.PIXELS);
       probeLogo.setSource(new ThemeResource("img/probe-updated.png"));
       probeLogo.setStyleName("probelogo");
       container.addComponent(probeLogo,"top:10px;left:50%");
       
        Label text = new Label();
        text.setWidth(610,Unit.PIXELS);
        text.setValue("<font style=\"font-weight: bold; font-size:18px\">Welcome to Proteomics Bioinformatics at the University of Bergen</font></br>"
                + "<font style=\"font-size: 12px;\">Our main objective is to combine state-of-the-art bioinformatics research with current biomedical knowledge, thus building a bridge between project specific high-throughput omics analyses and novel biomedical research!</font></br>"
                + "<font style=\"font-size: 12px;\">All of the proteomics tools are being developed by the <a class=\"link\" href=\"https://www.cbu.uib.no/barsnes/\" target=\"_blank\"> Barsnes Group </a>at the Computational Biology Unit (CBU) and the Proteomics Unit (PROBE), both at the University of Bergen, Norway.</font>");
        text.setContentMode(ContentMode.HTML);
        container.addComponent(text,"top:160px;left:50%");
        text.setStyleName("probetext");
        
        AbsoluteLayout leftContainer = new AbsoluteLayout();
        leftContainer.setWidth(299,Unit.PIXELS);
        leftContainer.setHeight(155,Unit.PIXELS);
        leftContainer.setStyleName("clickablebox");
        leftContainer.addStyleName("clickableboxleft");
        container.addComponent(leftContainer,"top:306px;left:50%");
        leftContainer.addLayoutClickListener((LayoutEvents.LayoutClickEvent event) -> {
            Page.getCurrent().open("https://proteomics.uib.no/csf-pr/", "_blank");
       });
        
        AbsoluteLayout rightContainer = new AbsoluteLayout();
        rightContainer.setWidth(299,Unit.PIXELS);
        rightContainer.setHeight(155,Unit.PIXELS);
        rightContainer.setStyleName("clickablebox");
        container.addComponent(rightContainer,"top:306px;left:50%");
        
        Label leftLabel = new Label();
        leftLabel.setContentMode(ContentMode.HTML);
        leftLabel.setSizeFull();
        leftContainer.addComponent(leftLabel,"left:15px;top:15px");
        leftLabel.setValue("<font align=\"left\" style=\"color:#ffffff;background-color: #4d749f;border-radius:4px;padding-top: 0px !important;padding-right: 7px !important;padding-left: 7px !important;padding-bottom: 1px;font-weight:bold;text-decoration:none;text-align: -webkit-center;text-align: center !important;\"><font style=\"color:#fffff;font-weight:bold;text-decoration:none;font-size: 16px;text-align: center;\">C</font></font><font align=\"left\" style=\"text-decoration:none;    margin-left: 2px;\"><font align=\"left\" ;=\"\" style=\"margin-left:0px;color:#4d749f;font-weight:bold;text-decoration:none;word-wrap: break-word !important;font-size: 16px; \">SF Proteome Resource</font></font><br/><br/><font style='font-size: 13px;text-align: justify ;'>Online repository of mass spectrometry\n" +
"based proteomics experiments on human cerebrospinal fluid.</font>");
        
        Label rightLabel = new Label();
        rightLabel.setContentMode(ContentMode.HTML);
        rightLabel.setSizeFull();
        rightContainer.addComponent(rightLabel,"left:15px;top:15px");
        rightLabel.setValue("<img class=\"v-image v-widget v-has-height\" src=\"./VAADIN/themes/mytheme/img/peptideshakericon.png\" alt=\"\" style='height: 55px;margin-top: -5px;'><font align=\"left\" style=\"text-decoration:none;    margin-left: 2px;\"><font align=\"left\" ;=\"\" style=\"margin-left:0px;color:#4d749f;font-weight:bold;text-decoration:none;word-wrap: break-word !important;font-size: 16px; \">PeptideShaker Online</font></font><br/><font style='font-size: 13px;text-align: justify ;'>User-friendly web-based framework for the identification of mass spectrometry-based proteomics data.</font>");
        
         rightContainer.addLayoutClickListener((LayoutEvents.LayoutClickEvent event) -> {
            Page.getCurrent().open("https://github.com/barsnes-group/peptide-shaker-online", "_blank");
       });
      
    }

   

}
