import { useState } from 'react'
import NotesList from './components/NotesList'
import AddNoteModal from './components/AddNoteModal'
import MapView from './components/MapView'
import { useNotes } from './hooks/useNotes'
import type { LocationNote, Note } from './types'

function App() {
  const [tab, setTab] = useState<'all' | 'photos' | 'map'>('all')
  const [openAdd, setOpenAdd] = useState(false)
  const { notes, loading, reload } = useNotes()

  function handleCreated(_note: Note) {
    reload()
  }

  const locations = notes.filter((n): n is LocationNote => n.kind === 'location')

  return (
    <div className="min-h-full bg-neutral-50 text-neutral-900 dark:bg-neutral-950 dark:text-neutral-100">
      <header className="sticky top-0 z-10 border-b border-neutral-200/60 dark:border-neutral-800/60 bg-white/80 dark:bg-neutral-900/80 backdrop-blur supports-[backdrop-filter]:bg-white/60 supports-[backdrop-filter]:dark:bg-neutral-900/60">
        <div className="mx-auto max-w-screen-md px-4 py-3 flex items-center justify-between">
          <h1 className="text-lg font-semibold tracking-tight">Notebook</h1>
          <button className="rounded-full p-2 hover:bg-neutral-100 dark:hover:bg-neutral-800" aria-label="Settings">
            <span className="i-[ph-gear-six-bold] size-5" />
          </button>
        </div>
        <nav className="mx-auto max-w-screen-md px-2 pb-2">
          <div className="grid grid-cols-3 gap-1 rounded-lg bg-neutral-100 dark:bg-neutral-800 p-1">
            <button onClick={() => setTab('all')} className={`py-2 rounded-md text-sm font-medium ${tab==='all' ? 'bg-white dark:bg-neutral-900 shadow' : 'text-neutral-600 dark:text-neutral-300'}`}>Alles</button>
            <button onClick={() => setTab('photos')} className={`py-2 rounded-md text-sm font-medium ${tab==='photos' ? 'bg-white dark:bg-neutral-900 shadow' : 'text-neutral-600 dark:text-neutral-300'}`}>Foto's</button>
            <button onClick={() => setTab('map')} className={`py-2 rounded-md text-sm font-medium ${tab==='map' ? 'bg-white dark:bg-neutral-900 shadow' : 'text-neutral-600 dark:text-neutral-300'}`}>Kaart</button>
          </div>
        </nav>
      </header>

      <main className="mx-auto max-w-screen-md px-4 pb-28 pt-4">
        {tab === 'all' && (
          <div className="space-y-3">
            {loading ? (
              <div className="rounded-xl border border-neutral-200/70 dark:border-neutral-800/70 bg-white dark:bg-neutral-900 p-4">Laden…</div>
            ) : (
              <NotesList notes={notes} filter="all" />
            )}
          </div>
        )}
        {tab === 'photos' && (
          loading ? (
            <div className="rounded-xl border border-neutral-200/70 dark:border-neutral-800/70 bg-white dark:bg-neutral-900 p-4">Laden…</div>
          ) : (
            <NotesList notes={notes} filter="photos" />
          )
        )}
        {tab === 'map' && (
          <div>
            <MapView locations={locations} />
            <div className="mt-3 text-xs text-neutral-500">Toon alle locatie-notities op de kaart</div>
          </div>
        )}
      </main>

      <button onClick={() => setOpenAdd(true)} className="fixed bottom-6 right-6 h-14 w-14 rounded-full bg-blue-600 text-white shadow-lg shadow-blue-600/30 hover:bg-blue-700 active:scale-95 transition" aria-label="Nieuwe notitie">
        +
      </button>

      <AddNoteModal open={openAdd} onClose={() => setOpenAdd(false)} onCreated={handleCreated} />
    </div>
  )
}

export default App
