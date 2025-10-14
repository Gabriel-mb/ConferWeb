const { app, BrowserWindow, Menu } = require('electron');
const path = require('path');

console.log('Electron starting...');
console.log('App path:', __dirname);

function createWindow() {
  console.log('Creating window...');
  
  const mainWindow = new BrowserWindow({
    width: 1200,
    height: 1000,
    // Remove a barra de menu
    frame: true, // true = bordas normais, false = sem bordas
    titleBarStyle: 'default', // Mantém os botões de controle
    autoHideMenuBar: false, // Não oculta automaticamente
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
      // Opcional: desabilita o contexto do DevTools
      devTools: false // Isso impede completamente o F12
    }
  });

  // Remove o menu de aplicação completamente
  Menu.setApplicationMenu(null);

  // Carrega do Angular
  console.log('Loading from localhost:4200');
  mainWindow.loadURL('http://localhost:4200');

  mainWindow.maximize();

  mainWindow.webContents.on('before-input-event', (event, input) => {
    if (input.key === 'F12' || (input.control && input.shift && input.key === 'I')) {
      event.preventDefault();
    }
  });
}

app.whenReady().then(createWindow);

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

app.on('activate', () => {
  if (BrowserWindow.getAllWindows().length === 0) {
    createWindow();
  }
});