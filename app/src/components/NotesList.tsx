import ReactMarkdown from 'react-markdown'
import remarkGfm from 'remark-gfm'
import type { Note } from '../types'

export default function NotesList({ notes, filter }: { notes: Note[]; filter: 'all' | 'photos' | 'map' }) {
  const filtered = notes.filter((n) => {
    if (filter === 'photos') return n.kind === 'photo'
    if (filter === 'map') return n.kind === 'location'
    return true
  })

  if (filtered.length === 0) {
    return <div className="rounded-xl border border-neutral-200/70 dark:border-neutral-800/70 bg-white dark:bg-neutral-900 p-4 text-sm text-neutral-600">Nog geen notities</div>
  }

  return (
    <div className="space-y-3">
      {filtered.map((note) => (
        <NoteCard key={note.id} note={note} />
      ))}
    </div>
  )
}

function NoteCard({ note }: { note: Note }) {
  if (note.kind === 'text') {
    return (
      <article className="rounded-xl border border-neutral-200/70 dark:border-neutral-800/70 bg-white dark:bg-neutral-900 p-4">
        {note.title && <h3 className="text-base font-semibold mb-1">{note.title}</h3>}
        {note.description && <p className="text-sm text-neutral-600 dark:text-neutral-300 mb-3">{note.description}</p>}
        <div className="prose prose-neutral dark:prose-invert max-w-none">
          <ReactMarkdown remarkPlugins={[remarkGfm]}>{note.content}</ReactMarkdown>
        </div>
        <div className="mt-3 text-xs text-neutral-500">{new Date(note.createdAt).toLocaleString()}</div>
      </article>
    )
  }

  if (note.kind === 'photo') {
    const hasMultiple = note.photos.length > 1
    return (
      <article className="rounded-xl border border-neutral-200/70 dark:border-neutral-800/70 bg-white dark:bg-neutral-900 overflow-hidden">
        <div className="aspect-[16/9] w-full bg-neutral-100 dark:bg-neutral-800">
          <div className={`w-full h-full ${hasMultiple ? 'overflow-x-auto snap-x snap-mandatory flex' : ''}`}>
            {note.photos.map((p) => (
              <img key={p.id} src={p.src} alt={note.title || 'foto'} className={`object-contain max-h-[70vh] w-full ${hasMultiple ? 'snap-center flex-shrink-0' : ''}`} style={{ aspectRatio: '16/9' }} />
            ))}
          </div>
        </div>
        <div className="p-4">
          {note.title && <h3 className="text-base font-semibold mb-1">{note.title}</h3>}
          {note.description && <p className="text-sm text-neutral-600 dark:text-neutral-300">{note.description}</p>}
          <div className="mt-3 text-xs text-neutral-500">{new Date(note.createdAt).toLocaleString()}</div>
        </div>
      </article>
    )
  }

  if (note.kind === 'location') {
    return (
      <article className="rounded-xl border border-neutral-200/70 dark:border-neutral-800/70 bg-white dark:bg-neutral-900 p-4">
        <h3 className="text-base font-semibold mb-1">{note.name}</h3>
        <p className="text-sm text-neutral-600 dark:text-neutral-300">{note.latitude.toFixed(5)}, {note.longitude.toFixed(5)}</p>
        <div className="mt-3 text-xs text-neutral-500">{new Date(note.createdAt).toLocaleString()}</div>
      </article>
    )
  }

  return null
}