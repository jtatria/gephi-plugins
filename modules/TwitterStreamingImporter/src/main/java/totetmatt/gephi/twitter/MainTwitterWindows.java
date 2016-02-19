package totetmatt.gephi.twitter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.WorkspaceListener;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import totetmatt.gephi.twitter.networklogic.Networklogic;
import twitter4j.JSONException;

@ConvertAsProperties(dtd = "-//org.gephi.plugins.example.panel//Simple//EN",
        autostore = false)
@TopComponent.Description(preferredID = "MainTwitterWindows",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "layoutmode", openAtStartup = true)
@ActionID(category = "Window", id = "org.gephi.plugins.twitter.panel.MainTwitterWindows")
@ActionReference(path = "Menu/Window", position = 333)
@TopComponent.OpenActionRegistration(displayName = "#CTL_SimpleAction",
        preferredID = "MainTwitterWindows")
public final class MainTwitterWindows extends TopComponent {

    private final TwitterStreamer streamer;
    private final DefaultListModel wordTrackingListModel = new DefaultListModel();
    private final DefaultTableModel userTrackingTableModel;
    private final ProjectController projectController;

    public MainTwitterWindows() {
        initComponents();
        setName(NbBundle.getMessage(MainTwitterWindows.class, "CTL_SimpleTopComponent"));
        setToolTipText(NbBundle.getMessage(MainTwitterWindows.class, "HINT_SimpleTopComponent"));
        Collection<Networklogic> networks = (Collection<Networklogic>) Lookup.getDefault().lookupAll(Networklogic.class);

        streamer = Lookup.getDefault().lookup(TwitterStreamer.class);

        DefaultComboBoxModel c = new DefaultComboBoxModel();
        for (Networklogic nl : networks) {
            c.addElement(nl);
        }
        network_logic_combo.setModel(c);

        userTrackingTableModel = (DefaultTableModel) ut_list_table.getModel();
        projectController = Lookup.getDefault().lookup(ProjectController.class);
        checkPluginEnabling();
        projectController.addWorkspaceListener(new WorkspaceListener() {
            @Override
            public void initialize(org.gephi.project.api.Workspace wrkspc) {
                checkPluginEnabling();
            }

            @Override
            public void select(org.gephi.project.api.Workspace wrkspc) {
                checkPluginEnabling();
            }

            @Override
            public void unselect(org.gephi.project.api.Workspace wrkspc) {
                checkPluginEnabling();
            }

            @Override
            public void close(org.gephi.project.api.Workspace wrkspc) {
                checkPluginEnabling();
            }

            @Override
            public void disable() {
                checkPluginEnabling();
            }

        });
      
    }

    private boolean isProjectWorkspaceOk() {
        return projectController.getCurrentProject() != null
                && projectController.getCurrentWorkspace() != null;
    }

    private void checkPluginEnabling() {
        if (isProjectWorkspaceOk()) {
            connect_toggleButton.setEnabled(true);
        } else {
            connect_toggleButton.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        connect_toggleButton = new javax.swing.JToggleButton();
        tracking_tab_panel = new javax.swing.JTabbedPane();
        wt_panel = new javax.swing.JPanel();
        wt_add_textfield = new javax.swing.JTextField();
        wt_add_button = new javax.swing.JButton();
        wt_word_list_scrollpane = new javax.swing.JScrollPane();
        wt_word_list = new javax.swing.JList<>();
        wt_word_list.setModel(wordTrackingListModel);
        wt_delete_button = new javax.swing.JButton();
        wt_add_label = new javax.swing.JLabel();
        wt_current_label = new javax.swing.JLabel();
        ut_panel = new javax.swing.JPanel();
        ut_list_scrollpane = new javax.swing.JScrollPane();
        ut_list_table = new javax.swing.JTable();
        ut_add_button = new javax.swing.JButton();
        ut_add_textfield = new javax.swing.JTextField();
        ut_delete_button = new javax.swing.JButton();
        ut_add_new_label = new javax.swing.JLabel();
        ut_current_user_label = new javax.swing.JLabel();
        credentials_panel = new javax.swing.JPanel();
        credential_goto_twitter_button = new javax.swing.JButton();
        credential_consumer_key_label = new javax.swing.JLabel();
        credential_consumer_secret_label = new javax.swing.JLabel();
        credential_consumer_key_field = new javax.swing.JTextField();
        credential_load_button = new javax.swing.JButton();
        credential_save_button = new javax.swing.JButton();
        credential_consumer_secret_field = new javax.swing.JTextField();
        credential_access_token_label = new javax.swing.JLabel();
        credential_access_token_secret_label = new javax.swing.JLabel();
        credential_access_token_field = new javax.swing.JTextField();
        credential_access_token_secret_field = new javax.swing.JTextField();
        network_logic_combo = new javax.swing.JComboBox<>();
        network_logic_label = new javax.swing.JLabel();
        load_tracking_button = new javax.swing.JButton();
        save_tracking_button = new javax.swing.JButton();

        jPasswordField1.setText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.jPasswordField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(connect_toggleButton, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.connect_toggleButton.text")); // NOI18N
        connect_toggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_toggleButtonActionPerformed(evt);
            }
        });

        wt_add_textfield.setText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_add_textfield.text")); // NOI18N
        wt_add_textfield.setToolTipText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_add_textfield.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(wt_add_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_add_button.text")); // NOI18N
        wt_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wt_add_buttonActionPerformed(evt);
            }
        });

        wt_word_list.setToolTipText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_word_list.toolTipText")); // NOI18N
        wt_word_list_scrollpane.setViewportView(wt_word_list);

        org.openide.awt.Mnemonics.setLocalizedText(wt_delete_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_delete_button.text")); // NOI18N
        wt_delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wt_delete_buttonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(wt_add_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_add_label.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(wt_current_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_current_label.text")); // NOI18N

        javax.swing.GroupLayout wt_panelLayout = new javax.swing.GroupLayout(wt_panel);
        wt_panel.setLayout(wt_panelLayout);
        wt_panelLayout.setHorizontalGroup(
            wt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wt_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wt_add_label)
                    .addComponent(wt_current_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(wt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wt_panelLayout.createSequentialGroup()
                        .addComponent(wt_add_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(wt_add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(wt_panelLayout.createSequentialGroup()
                        .addComponent(wt_word_list_scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wt_delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))))
        );
        wt_panelLayout.setVerticalGroup(
            wt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wt_panelLayout.createSequentialGroup()
                .addGroup(wt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wt_add_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wt_add_button)
                    .addComponent(wt_add_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(wt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wt_panelLayout.createSequentialGroup()
                        .addGroup(wt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wt_word_list_scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addGroup(wt_panelLayout.createSequentialGroup()
                                .addComponent(wt_current_label)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(11, 11, 11))
                    .addGroup(wt_panelLayout.createSequentialGroup()
                        .addComponent(wt_delete_button)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tracking_tab_panel.addTab(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.wt_panel.TabConstraints.tabTitle"), wt_panel); // NOI18N

        ut_list_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Screen Name", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ut_list_table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ut_list_scrollpane.setViewportView(ut_list_table);

        org.openide.awt.Mnemonics.setLocalizedText(ut_add_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.ut_add_button.text")); // NOI18N
        ut_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ut_add_buttonActionPerformed(evt);
            }
        });

        ut_add_textfield.setText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.ut_add_textfield.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(ut_delete_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.ut_delete_button.text")); // NOI18N
        ut_delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ut_delete_buttonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(ut_add_new_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.ut_add_new_label.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(ut_current_user_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.ut_current_user_label.text")); // NOI18N

        javax.swing.GroupLayout ut_panelLayout = new javax.swing.GroupLayout(ut_panel);
        ut_panel.setLayout(ut_panelLayout);
        ut_panelLayout.setHorizontalGroup(
            ut_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ut_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ut_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ut_panelLayout.createSequentialGroup()
                        .addComponent(ut_add_new_label)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(ut_current_user_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ut_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ut_list_scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(ut_add_textfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ut_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ut_delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ut_add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        ut_panelLayout.setVerticalGroup(
            ut_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ut_panelLayout.createSequentialGroup()
                .addGroup(ut_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ut_add_button)
                    .addComponent(ut_add_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ut_add_new_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ut_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ut_list_scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ut_delete_button)
                    .addComponent(ut_current_user_label))
                .addContainerGap())
        );

        tracking_tab_panel.addTab(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.ut_panel.TabConstraints.tabTitle"), ut_panel); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(credential_goto_twitter_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_goto_twitter_button.text")); // NOI18N
        credential_goto_twitter_button.setActionCommand(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_goto_twitter_button.actionCommand")); // NOI18N
        credential_goto_twitter_button.setBorder(null);
        credential_goto_twitter_button.setBorderPainted(false);
        credential_goto_twitter_button.setContentAreaFilled(false);
        credential_goto_twitter_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credential_goto_twitter_buttonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(credential_consumer_key_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_consumer_key_label.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(credential_consumer_secret_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_consumer_secret_label.text")); // NOI18N

        credential_consumer_key_field.setText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_consumer_key_field.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(credential_load_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_load_button.text")); // NOI18N
        credential_load_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credential_load_buttonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(credential_save_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_save_button.text")); // NOI18N
        credential_save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credential_save_buttonActionPerformed(evt);
            }
        });

        credential_consumer_secret_field.setText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_consumer_secret_field.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(credential_access_token_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_access_token_label.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(credential_access_token_secret_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_access_token_secret_label.text")); // NOI18N

        credential_access_token_field.setText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_access_token_field.text")); // NOI18N

        credential_access_token_secret_field.setText(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credential_access_token_secret_field.text")); // NOI18N

        javax.swing.GroupLayout credentials_panelLayout = new javax.swing.GroupLayout(credentials_panel);
        credentials_panel.setLayout(credentials_panelLayout);
        credentials_panelLayout.setHorizontalGroup(
            credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentials_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(credentials_panelLayout.createSequentialGroup()
                        .addComponent(credential_load_button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(credential_save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(credential_goto_twitter_button, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(credentials_panelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(credential_consumer_key_label, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(credential_consumer_key_field))
                    .addGroup(credentials_panelLayout.createSequentialGroup()
                        .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(credential_access_token_label)
                            .addComponent(credential_consumer_secret_label)
                            .addComponent(credential_access_token_secret_label))
                        .addGap(14, 14, 14)
                        .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(credential_consumer_secret_field, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(credential_access_token_field)
                            .addComponent(credential_access_token_secret_field))))
                .addContainerGap())
        );
        credentials_panelLayout.setVerticalGroup(
            credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentials_panelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(credential_load_button)
                    .addComponent(credential_save_button)
                    .addComponent(credential_goto_twitter_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(credential_consumer_key_label)
                    .addComponent(credential_consumer_key_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(credential_consumer_secret_label)
                    .addComponent(credential_consumer_secret_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(credentials_panelLayout.createSequentialGroup()
                        .addGroup(credentials_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(credential_access_token_label)
                            .addComponent(credential_access_token_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(credential_access_token_secret_label))
                    .addComponent(credential_access_token_secret_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tracking_tab_panel.addTab(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.credentials_panel.TabConstraints.tabTitle"), credentials_panel); // NOI18N

        network_logic_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.openide.awt.Mnemonics.setLocalizedText(network_logic_label, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.network_logic_label.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(load_tracking_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.load_tracking_button.text")); // NOI18N
        load_tracking_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_tracking_buttonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(save_tracking_button, org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.save_tracking_button.text")); // NOI18N
        save_tracking_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_tracking_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(connect_toggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tracking_tab_panel)
                    .addComponent(network_logic_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(network_logic_label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(load_tracking_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save_tracking_button)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(network_logic_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(network_logic_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(load_tracking_button)
                    .addComponent(save_tracking_button))
                .addGap(14, 14, 14)
                .addComponent(tracking_tab_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connect_toggleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tracking_tab_panel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.tracking_tab_panel.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void connect_toggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_toggleButtonActionPerformed
        if (connect_toggleButton.isSelected()) {
            streamer.start((Networklogic) network_logic_combo.getSelectedItem());
            connect_toggleButton.setText("Disconnect");
        } else {
            streamer.stop();
            connect_toggleButton.setText("Connect");
        }
    }//GEN-LAST:event_connect_toggleButtonActionPerformed

    private void wt_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wt_add_buttonActionPerformed
        streamer.addWordTracking(wt_add_textfield.getText().trim().toLowerCase());
        wt_add_textfield.setText("");
        refreshWordList();

    }//GEN-LAST:event_wt_add_buttonActionPerformed

    private void wt_delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wt_delete_buttonActionPerformed
        streamer.getWordTracking().removeAll(wt_word_list.getSelectedValuesList());
        refreshWordList();
    }//GEN-LAST:event_wt_delete_buttonActionPerformed

    private void credential_goto_twitter_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credential_goto_twitter_buttonActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://apps.twitter.com/"));
            } catch (IOException e) {
               Logger.getLogger(MainTwitterWindows.class.getName()).log(Level.SEVERE, null, e);
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainTwitterWindows.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Logger.getLogger(MainTwitterWindows.class.getName()).log(Level.SEVERE, null, new Exception("Desktop method isn't supported")); 
        }
    }//GEN-LAST:event_credential_goto_twitter_buttonActionPerformed

    private void credential_load_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credential_load_buttonActionPerformed
        /**/
        streamer.getCredentialProperty().load();
        credential_consumer_key_field.setText(streamer.getCredentialProperty().getConsumerKey());
        credential_consumer_secret_field.setText(streamer.getCredentialProperty().getConsumerSecret());
        credential_access_token_field.setText(streamer.getCredentialProperty().getToken());
        credential_access_token_secret_field.setText(streamer.getCredentialProperty().getTokenSecret());
    }//GEN-LAST:event_credential_load_buttonActionPerformed

    private void credential_save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credential_save_buttonActionPerformed
        /**/
        streamer.getCredentialProperty().setConsumerKey(credential_consumer_key_field.getText().trim());
        streamer.getCredentialProperty().setConsumerSecret(credential_consumer_secret_field.getText().trim());
        streamer.getCredentialProperty().setToken(credential_access_token_field.getText().trim());
        streamer.getCredentialProperty().setTokenSecret(credential_access_token_secret_field.getText().trim());
        streamer.getCredentialProperty().save();
    }//GEN-LAST:event_credential_save_buttonActionPerformed

    private void load_tracking_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_tracking_buttonActionPerformed
        final JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.file_chooser.format"), "json", "application/json");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                streamer.loadTracking(file);
            } catch (IOException ex) {
                Logger.getLogger(MainTwitterWindows.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(MainTwitterWindows.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshTracking();
        }
    }//GEN-LAST:event_load_tracking_buttonActionPerformed

    private void save_tracking_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_tracking_buttonActionPerformed
        final JFileChooser fc = new JFileChooser();

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(org.openide.util.NbBundle.getMessage(MainTwitterWindows.class, "MainTwitterWindows.file_chooser.format"), "json", "application/json");
        fc.setFileFilter(filter);
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                streamer.saveTracking(file);
            } catch (JSONException ex) {
                Logger.getLogger(MainTwitterWindows.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainTwitterWindows.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_save_tracking_buttonActionPerformed

    private void ut_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ut_add_buttonActionPerformed
        streamer.addUser(ut_add_textfield.getText().trim().toLowerCase());
        refreshUserList();

    }//GEN-LAST:event_ut_add_buttonActionPerformed

    private void ut_delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ut_delete_buttonActionPerformed
        for (int row : ut_list_table.getSelectedRows()) {
            streamer.getUserTracking().remove(userTrackingTableModel.getValueAt(row, 0));
        }
        refreshUserList();
    }//GEN-LAST:event_ut_delete_buttonActionPerformed
    private void refreshTracking() {
        refreshWordList();
        refreshUserList();
    }

    private void refreshWordList() {
        wordTrackingListModel.clear();
        for (String s : streamer.getWordTracking()) {
            wordTrackingListModel.add(0, s);
        }
    }

    private void refreshUserList() {
        ut_list_table.clearSelection();
        ut_list_table.updateUI();
        userTrackingTableModel.getDataVector().removeAllElements();
        for (Map.Entry<String, Long> entry : streamer.getUserTracking().entrySet()) {
            userTrackingTableModel.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton connect_toggleButton;
    private javax.swing.JTextField credential_access_token_field;
    private javax.swing.JLabel credential_access_token_label;
    private javax.swing.JTextField credential_access_token_secret_field;
    private javax.swing.JLabel credential_access_token_secret_label;
    private javax.swing.JTextField credential_consumer_key_field;
    private javax.swing.JLabel credential_consumer_key_label;
    private javax.swing.JTextField credential_consumer_secret_field;
    private javax.swing.JLabel credential_consumer_secret_label;
    private javax.swing.JButton credential_goto_twitter_button;
    private javax.swing.JButton credential_load_button;
    private javax.swing.JButton credential_save_button;
    private javax.swing.JPanel credentials_panel;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton load_tracking_button;
    private javax.swing.JComboBox<String> network_logic_combo;
    private javax.swing.JLabel network_logic_label;
    private javax.swing.JButton save_tracking_button;
    private javax.swing.JTabbedPane tracking_tab_panel;
    private javax.swing.JButton ut_add_button;
    private javax.swing.JLabel ut_add_new_label;
    private javax.swing.JTextField ut_add_textfield;
    private javax.swing.JLabel ut_current_user_label;
    private javax.swing.JButton ut_delete_button;
    private javax.swing.JScrollPane ut_list_scrollpane;
    private javax.swing.JTable ut_list_table;
    private javax.swing.JPanel ut_panel;
    private javax.swing.JButton wt_add_button;
    private javax.swing.JLabel wt_add_label;
    private javax.swing.JTextField wt_add_textfield;
    private javax.swing.JLabel wt_current_label;
    private javax.swing.JButton wt_delete_button;
    private javax.swing.JPanel wt_panel;
    private javax.swing.JList<String> wt_word_list;
    private javax.swing.JScrollPane wt_word_list_scrollpane;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
