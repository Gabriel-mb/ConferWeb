const { contextBridge, ipcRenderer } = require('electron');

contextBridge.exposeInMainWorld('electronAPI', {
  showDialog: (message) => ipcRenderer.invoke('show-dialog', message)
});